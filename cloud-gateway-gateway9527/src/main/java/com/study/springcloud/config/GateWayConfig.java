package com.study.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 这是通过config类配置，用yml配置文件会很大。
 *
 * 配置了一个id为routr-name的路由规则
 * 当访问地址http://localhost:9527/guonei时会自动转发到http://news.baidu.com/guonei
 * */
@Configuration
public class GateWayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        // 路由构造器
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        // 设置路径
        routes.route("baidu_news_guonei_routh", r -> {
            return r.path("/songlist").uri("http://music.91q.com/songlist");
        });
//        routes.route("baidu_news_guoji_routh", r -> {
//            return r.path("/payment/lb").uri("http://localhost:8001/payment/lb");
//        });

        return routes.build();
    }
}