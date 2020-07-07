package org.gdz.mycloud.service.provider.s2.core;

import org.apache.dubbo.config.annotation.Service;
import org.gdz.mycloud.common.base.model.Result;
import org.gdz.mycloud.common.base.model.ResultBuilder;
import org.gdz.mycloud.common.nacos.config.properties.api.s2.S2Properties;
import org.gdz.mycloud.service.provider.api.s2.S2ProviderApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @Author: guduzhou
 * @Description:
 * @Date: Created in 17:46 2020/6/28 0028
 * @Modified By:
 */
@Component
@Service(version = "1.0.0")
@RefreshScope
public class S1ProviderService implements S2ProviderApi {

    @Value("${s1.name}")
    private String useLocalCache;

    @Autowired
    private S2Properties s2Properties;

    @Override
    public Result<String> test() {
        System.out.println(s2Properties);
        return ResultBuilder.buildBussinessOk(useLocalCache);
    }
}
