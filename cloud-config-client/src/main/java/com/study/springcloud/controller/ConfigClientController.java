package com.study.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope //实时刷新，使客户端服务具有刷新功能
public class ConfigClientController {
    @Value("${config.info}")
     String configInfo;

    @GetMapping("/getInfo")
    public String getInfo(){
        return  configInfo;
    }
}
