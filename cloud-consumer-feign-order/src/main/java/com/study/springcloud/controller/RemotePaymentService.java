package com.study.springcloud.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


/**
 *  调用的mcroservice-payment服务的
 *  8001，8002负载获取接口
 *  也可以在mcroservice-payment服务实现接口，然后本模块pom引入依赖调用
 */
@FeignClient(contextId = "remotePaymentServiceId",
        name = "mcroservice-payment",
        value = "mcroservice-payment")
public interface RemotePaymentService {
    @GetMapping("payment/get/{id}")
    public String queryById(@PathVariable(value = "id") Long id);

}
