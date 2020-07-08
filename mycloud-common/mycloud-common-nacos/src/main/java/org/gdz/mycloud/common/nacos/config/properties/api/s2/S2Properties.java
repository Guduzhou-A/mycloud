package org.gdz.mycloud.common.nacos.config.properties.api.s2;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.gdz.mycloud.common.nacos.constant.NacosConstant;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: guduzhou
 * @Description:
 * @Date: Created in 17:17 2020/6/22 0022
 * @Modified By:
 */
//@NacosConfigurationProperties(prefix = NacosConstant.Prefix.TEST_SERVICE_API_S2
//        , dataId = NacosConstant.DataId.TEST_SERVICE_API_S2
//        , groupId = NacosConstant.DataId.TEST_SERVICE_API_S2
//        , autoRefreshed = true)
@ConfigurationProperties(prefix = NacosConstant.Prefix.TEST_SERVICE_API_S2)
@Data
@NoArgsConstructor
@Configuration
public class S2Properties {

    private String name;

}
