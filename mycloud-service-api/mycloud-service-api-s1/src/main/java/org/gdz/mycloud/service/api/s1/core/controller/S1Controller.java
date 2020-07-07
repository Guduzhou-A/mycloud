package org.gdz.mycloud.service.api.s1.core.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.gdz.mycloud.common.base.model.Result;
import org.gdz.mycloud.service.provider.api.s1.S1ProviderApi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: guduzhou
 * @Description:
 * @Date: Created in 17:29 2020/6/29 0029
 * @Modified By:
 */
@RestController
@RequestMapping("s1")
public class S1Controller {

    @Reference(version = "1.0.0")
    private S1ProviderApi s1ProviderApi;

    @GetMapping("test")
    public Result<String> s1Test() {
        return s1ProviderApi.test();
    }
}
