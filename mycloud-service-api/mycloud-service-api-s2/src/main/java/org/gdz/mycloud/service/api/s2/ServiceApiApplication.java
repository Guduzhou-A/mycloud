package org.gdz.mycloud.service.api.s2;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.gdz.mycloud.common.config.handler.GlobalExceptionHandler;
import org.gdz.mycloud.common.config.mvc.MyWebMvcConfig;
import org.gdz.mycloud.common.nacos.discovery.DiscoveryConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * @Author: guduzhou
 * @Description:
 * @Date: Created in 17:25 2020/6/29 0029
 * @Modified By:
 */

@SpringBootApplication(scanBasePackages = {"org.gdz.mycloud.service.api.s2.core"})
@Slf4j
@EnableDubbo
@Import({DiscoveryConfig.class, MyWebMvcConfig.class, GlobalExceptionHandler.class})
public class ServiceApiApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ServiceApiApplication.class);
        application.run(args);
        log.info("s2 ServiceApiApplication started successfully");
    }

}
