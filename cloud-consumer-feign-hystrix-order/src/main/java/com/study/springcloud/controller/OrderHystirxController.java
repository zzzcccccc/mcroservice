package com.study.springcloud.controller;


import com.study.springcloud.feign.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OrderHystirxController {

    @Autowired
    private PaymentHystrixService paymentHystrixService;


    @GetMapping("/consumer/hystrix/ok/{id}")
    String paymentInfo_OK(@PathVariable("id") Integer id){
        return  paymentHystrixService.paymentInfo_OK(id);
    }


    @GetMapping("/consumer/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        //int age = 10/0;
        return paymentHystrixService.paymentInfo_TimeOut(id);
    }



//    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",
//                    value = "1000")
//    })
//    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
//        //int age = 10/0;
//        return paymentHystrixService.paymentInfo_TimeOut(id);
//    }

    //服务降级的兜底的方法
//    public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id) {
//        return "我是消费者80,对方支付系统繁忙请10秒种后再试或者自己运行出错请检查自己,o(╥﹏╥)o";
//    }

}