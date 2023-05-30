package com.study.springcloud.controller;

import com.study.springcloud.feign.RemotePaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@Slf4j
public class OrderController {
    @Autowired
    private RemotePaymentService remotePaymentService;

    @GetMapping("/consumer/payment/get/{id}")
    public String getPaymentById(@PathVariable("id") Long id){
        String s = remotePaymentService.queryById(id);
        return s;
    }

    @GetMapping("/getTest")
    public String getTest(){
        log.info("2222");
        System.out.println("***************查询成功*********");
        return "Feign----chenggong";
    }

}
