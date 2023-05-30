package com.study.springcloud.order.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@Slf4j
public class OrderController {
    //调用支付订单服务端的ip+端口号
    public static final  String PAYMENT_URL = "http://mcroservice-payment";

    @Autowired
    private RestTemplate restTemplate;

    //获取id获取支付订单
    @GetMapping("/consumer/payment/get/{id}")
    public String getPayment(@PathVariable("id") Long id){

        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,String.class);
    }
}
