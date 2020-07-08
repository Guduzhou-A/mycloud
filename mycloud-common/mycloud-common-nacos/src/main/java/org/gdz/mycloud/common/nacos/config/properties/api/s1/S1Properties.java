package org.gdz.mycloud.common.nacos.config.properties.api.s1;

import com.alibaba.nacos.api.config.annotation.NacosConfigurationProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.gdz.mycloud.common.nacos.constant.NacosConstant;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Author: guduzhou
 * @Description:
 * @Date: Created in 17:17 2020/6/22 0022
 * @Modified By:
 */
//@NacosConfigurationProperties(prefix = NacosConstant.Prefix.TEST_SERVICE_API_S1
//        , dataId = NacosConstant.DataId.TEST_SERVICE_API_S1
//        , autoRefreshed = true)
@ConfigurationProperties(prefix = NacosConstant.Prefix.TEST_SERVICE_API_S1)
@Data
@NoArgsConstructor
@Configuration
public class S1Properties {

    private String name;

}
