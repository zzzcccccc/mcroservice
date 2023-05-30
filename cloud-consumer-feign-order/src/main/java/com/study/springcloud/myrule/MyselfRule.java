package com.study.springcloud.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *  Ribbon在工作时分为两步：(负载均衡，作用在本地，调用接口的时候)
 *
 * 第一步先选择EurekaServer，它优先选择在同一个区域内负载较少的Server。
 * 第二步再根据用户指定的策略，在从Server取到服务注册列表中选择一个地址。
 * 其中ribbon提供了多种策略，比如轮询、随机、根据时间响应时间加权等。
 *
 * 配合ApplicationContextConfig类的方法，Ribbon+RestTemplate
 */
@Configuration
public class MyselfRule {
    @Bean
    public IRule myRule() {
        // 定义为随机等……
        return new RoundRobinRule();
//        return new RandomRule();
    }
}
