package org.gdz.mycloud.common.config.handler;

import lombok.extern.slf4j.Slf4j;
import org.gdz.mycloud.common.base.enums.BussinessCode;
import org.gdz.mycloud.common.base.exception.BaseException;
import org.gdz.mycloud.common.base.exception.BussinessException;
import org.gdz.mycloud.common.base.model.Result;
import org.gdz.mycloud.common.base.model.ResultBuilder;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;

/**
 * 全局异常信息处理
 *
 * @author guduzhou
 * @return
 * @date 2020年04月29日 17时57分59秒
 */

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler({HttpMessageNotReadableException.class})
    public Result requestNotReadable(HttpServletRequest request, HttpMessageNotReadableException ex) {
        sendLog(request, ex);
        return ResultBuilder.buildHttpError(ex.getMessage());
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    public Result constraintViolationExceptionHandler(HttpServletRequest request, ConstraintViolationException ex) {
        sendLog(request, ex);
        // 拼接错误
        StringBuilder detailMessage = new StringBuilder();
        for (ConstraintViolation<?> constraintViolation : ex.getConstraintViolations()) {
            // 使用 ; 分隔多个错误
            if (detailMessage.length() > 0) {
                detailMessage.append(";");
            }
            // 拼接内容到其中
            detailMessage.append(constraintViolation.getMessage());
        }
        return ResultBuilder.buildError(BussinessCode.SYSTEM_REQUEST_UNAUTHORIZED.code(),
                BussinessCode.SYSTEM_REQUEST_UNAUTHORIZED.msg() + ":" + detailMessage.toString());
    }

    @ExceptionHandler(value = BindException.class)
    public Result bindExceptionHandler(HttpServletRequest request, BindException ex) {
        sendLog(request, ex);
        // 拼接错误
        String errorMsg = buildErrorMsg(ex.getAllErrors());
        return ResultBuilder.buildError(BussinessCode.SYSTEM_REQUEST_UNAUTHORIZED.code(),
                BussinessCode.SYSTEM_REQUEST_UNAUTHORIZED.msg() + ":" + errorMsg);
    }

    @ExceptionHandler({BaseException.class})
    public Result bizExceptionHandler(HttpServletRequest request, BaseException ex) {
        sendLog(request, ex);
        return ResultBuilder.buildError(ex.getCode(), ex.getMsg());
    }

    @ExceptionHandler({BussinessException.class})
    public Result baseExceptionHandler(HttpServletRequest request, BussinessException ex) {

        sendLog(request, ex);

        return ResultBuilder.buildError(ex.getCode(), ex.getMsg());
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Result methodArgumentNotValidExceptionHandler(HttpServletRequest request, MethodArgumentNotValidException ex) {
        sendLog(request, ex);
        FieldError fieldError = ex.getBindingResult().getFieldError();
        assert fieldError != null;
        String errorMsg = fieldError.getField() + ":" + fieldError.getDefaultMessage();

        return ResultBuilder.buildError(BussinessCode.SYSTEM_REQUEST_UNAUTHORIZED.code(),
                BussinessCode.SYSTEM_REQUEST_UNAUTHORIZED.msg() + ":" + errorMsg);
    }

    /**
     * @Description: 系统异常捕获处理
     */

    @ExceptionHandler(value = Exception.class)
    public Result javaExceptionHandler(HttpServletRequest request, Exception ex) {

        sendLog(request, ex);

        if (ex instanceof NoHandlerFoundException) {
            return ResultBuilder.buildBussinessError(BussinessCode.SYSTEM_REQUEST_API_NOT_FOUND);
        }
        if (ex instanceof MissingServletRequestParameterException) {
            return ResultBuilder.buildBussinessError(BussinessCode.SYSTEM_REQUEST_UNAUTHORIZED);
        }
        if (ex instanceof MethodArgumentTypeMismatchException) {
            return ResultBuilder.buildBussinessError(BussinessCode.SYSTEM_REQUEST_ILLEGAL_REQUEST);
        }
        if (ex instanceof HttpRequestMethodNotSupportedException) {
            return ResultBuilder.buildBussinessError(BussinessCode.SYSTEM_REQUEST_BAD_REQUEST);
        }
        if (ex instanceof RuntimeException) {
            return ResultBuilder.buildBussinessError(BussinessCode.SYSTEM_REQUEST_REMOTE_SERVICE_ERROR);
        }
        if (ex instanceof ServletRequestBindingException) {
            return ResultBuilder.buildBussinessError(BussinessCode.SYSTEM_REQUEST_ILLEGAL_REQUEST);
        }

        return ResultBuilder.buildBussinessError(BussinessCode.SYSTEM_BASIC_NORMAL_ERROR);
    }

    private void sendLog(HttpServletRequest request, Exception ex) {
        log.info("请求地址 : " + request.getRequestURL().toString());
        log.info("HTTP METHOD : " + request.getMethod());
        log.error("捕获到Exception异常", ex);
    }

    private String buildErrorMsg(List<ObjectError> objectErrorList) {
        StringBuilder detailMessage = new StringBuilder();
        for (ObjectError objectError : objectErrorList) {
            // 使用 ; 分隔多个错误
            if (detailMessage.length() > 0) {
                detailMessage.append(";");
            }
            // 拼接内容到其中
            detailMessage.append(objectError.getDefaultMessage());
        }
        return detailMessage.toString();
    }
}
