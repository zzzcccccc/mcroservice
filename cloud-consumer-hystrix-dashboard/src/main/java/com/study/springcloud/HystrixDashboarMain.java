package com.study.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard  //视图监控注解
public class HystrixDashboarMain {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboarMain.class,args);
    }
}