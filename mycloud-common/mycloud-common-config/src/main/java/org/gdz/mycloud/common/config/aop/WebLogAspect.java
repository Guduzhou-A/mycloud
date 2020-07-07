package org.gdz.mycloud.common.config.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.gdz.mycloud.common.base.anno.AuthLogAnnotation;
import org.gdz.mycloud.common.base.util.FastJsonUtil;
import org.gdz.mycloud.common.config.base.util.NetworkUtil;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class WebLogAspect {

    @Pointcut("execution(public * org.gdz.mycloud.*.controller.*.*(..))")
    public void logPointCut() {
    }

    private String desc;
    private String requestURL;
    private String ip;
    private String methodName;
    private String classMethod;
    private String parameter;
    private String body;

    @Before("logPointCut()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes == null) {
            return;
        }
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        MethodSignature sign = (MethodSignature) joinPoint.getSignature();
        //获取注解
        //获取aop截取方法上的注解
        Method method = sign.getMethod();
        AuthLogAnnotation annotation = method.getAnnotation(AuthLogAnnotation.class);

        desc = "";
        if (annotation != null) {
            desc = "【" + annotation.desc() + "】";
        }

        Object[] args = joinPoint.getArgs();
        Object[] arguments = new Object[args.length];
        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof ServletRequest ||
                    args[i] instanceof ServletResponse ||
                    args[i] instanceof MultipartFile ||
                    args[i] instanceof BindingResult
            ) {
                continue;
            }
            arguments[i] = args[i];
        }
        String params;
        try {
            params = FastJsonUtil.format(arguments);
        } catch (Exception e) {
            params = Arrays.toString(arguments);
        }

        requestURL = request.getRequestURI();
        ip = NetworkUtil.getIpAddress(request);
        methodName = request.getMethod();
        classMethod = sign.getDeclaringTypeName() + "." + sign.getName();
        parameter = FastJsonUtil.format(request.getParameterMap());
        body = params;
    }

    @Around("logPointCut()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object ob = pjp.proceed();
        log.info("----> | " + desc + " 耗时 : " + (System.currentTimeMillis() - startTime));
        return ob;
    }

    @AfterReturning(returning = "ret", pointcut = "logPointCut()")
    public void doAfterReturning(Object ret) throws Throwable {

        // 处理完请求，返回内容(返回值太复杂时，打印的是物理存储空间的地址)
        log.info("-------------------------------log msg start---------------------------------------");
        log.info("----> | " + desc + " 请求地址 : " + requestURL);
        log.info("----> | " + desc + " IP : " + ip);
        log.info("----> | " + desc + " HTTP METHOD : " + methodName);
        log.info("----> | " + desc + " CLASS_METHOD : " + classMethod);
        log.info("----> | " + desc + " request参数 : " + parameter);
        log.info("----> | " + desc + " 参数 : " + body);
        log.info("----> | " + desc + " 返回值 : " + FastJsonUtil.format(ret));
        log.info("-------------------------------log msg end---------------------------------------");
    }

}
