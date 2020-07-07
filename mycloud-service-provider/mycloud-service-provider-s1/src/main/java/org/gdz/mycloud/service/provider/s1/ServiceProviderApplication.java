package org.gdz.mycloud.service.provider.s1;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.gdz.mycloud.common.config.handler.GlobalExceptionHandler;
import org.gdz.mycloud.common.config.mvc.MyWebMvcConfig;
import org.gdz.mycloud.common.nacos.config.properties.api.s1.S1Properties;
import org.gdz.mycloud.common.nacos.discovery.DiscoveryConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * @Author: guduzhou
 * @Description:
 * @Date: Created in 19:27 2020/6/28 0028
 * @Modified By:
 */
@SpringBootApplication(scanBasePackages = {"org.gdz.mycloud.service.provider.s1.core"})
@Slf4j
@EnableDubbo(scanBasePackages = {"org.gdz.mycloud.service.provider.api.s1"})
@Import({DiscoveryConfig.class, MyWebMvcConfig.class, S1Properties.class, GlobalExceptionHandler.class})
public class ServiceProviderApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ServiceProviderApplication.class);
        application.run(args);
        log.info("ServiceProviderApplication started successfully");
    }

}
