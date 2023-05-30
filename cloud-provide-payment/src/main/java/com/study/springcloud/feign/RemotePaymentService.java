package com.study.springcloud.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(contextId = "remotePaymentServiceId",name = "mcroservice-payment", value = "mcroservice-payment")
public interface RemotePaymentService {
    @GetMapping("payment/get/{id}")
    public String queryById(@PathVariable(value = "id") Long id);

}
