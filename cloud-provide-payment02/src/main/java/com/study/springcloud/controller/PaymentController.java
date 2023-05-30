package com.study.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PaymentController {

    @GetMapping("/payment/get/{id}")
    public String queryById(@PathVariable("id") Long id){
        log.info("2222");
        System.out.println("***************查询成功02*********");
        return "成功了";
    }

}
