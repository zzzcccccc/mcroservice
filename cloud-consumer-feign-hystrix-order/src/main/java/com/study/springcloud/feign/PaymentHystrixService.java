package com.study.springcloud.feign;

import com.study.springcloud.hystrixs.PaymentFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(contextId = "paymentHystrixService",
             value = "cloud-provider-hystrix-payment",
             fallback = PaymentFallbackService.class)
//value属性是从该服务中获取，fallback属性当服务出现故障时，该类进行服务降级处理

public interface PaymentHystrixService {

    /**
     * 正常访问
     *
     * @param id
     * @return
     */
    @GetMapping("/payment/hystrix/ok/{id}")
    String paymentInfo_OK(@PathVariable("id") Integer id);

    /**
     * 超时访问
     *
     * @param id
     * @return
     */
    @GetMapping("/payment/hystrix/timeout/{id}")
    String paymentInfo_TimeOut(@PathVariable("id") Integer id);

}
