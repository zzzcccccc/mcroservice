package com.study.springcloud.order.config;


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * RestTemplate 远程调用
 * @LoadBalanced 注解实现负载均衡，轮询模式
 *  配合ribbon负载设置访问的模式    Ribbon+RestTemplate
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
