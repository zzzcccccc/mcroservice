package com.study.springcloud;

import com.study.springcloud.filter.TokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class GatewayMain {
    public static void main(String[] args) {
        SpringApplication.run(GatewayMain.class,args);
    }


    /**
     * 启动类中注入到Spring Ioc容器中，代码如下：
     * @return
     */
    @Bean
    public TokenFilter tokenFilter(){
        return new TokenFilter();
    }

}


