package com.study.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    /**
     * 正常访问
     *
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + " paymentInfo_OK,id:" + id + "\t" + "O(∩_∩)O哈哈~";
    }

    /**
     * 超时访问(@HystrixCommand 注解)
     *
     * @param id
     * @return
     */
//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHabdler",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
//    } )
    public String paymentInfo_TimeOut(Integer id) {
        int timeNumber = 2;
        try {
            // 暂停3秒钟
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "线程池:" + Thread.currentThread().getName() + " paymentInfo_TimeOut,id:" + id + "\t" +
                "O(∩_∩)O哈哈~  耗时(秒)" + timeNumber;
    }

    /**
     * 超时访问到这里兜底
     *
     * @param id
     * @return
     */
//    public String paymentInfo_TimeOutHabdler(Integer id) {
//        return "线程池:" + Thread.currentThread().getName() + " paymentInfo_TimeOutHabdler,id:" + id + "\t" +
//                "系统繁忙，请稍后再试****o(╥﹏╥)o" ;
//    }


    /**
     * 熔断
     * @param id
     * @return
     *
     * 比如：在10秒内，发生20次以上的请求时，假如错误率达到50%以上，则断路器将被打开。
     * （当一个窗口期过去的时候，断路器将变成半开（HALF-OPEN）（默认5秒）状态，如果这时候发生的请求正常，则关闭，否则又打开）
     *
     */
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),// 失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker( Integer id)
    {
        if(id < 0)
        {
            throw new RuntimeException("******id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"\t"+"调用成功，流水号: " + serialNumber;
    }
    //兜底降级的方法
    public String paymentCircuitBreaker_fallback(Integer id)
    {
        return "id 不能负数，请稍后再试，/(ㄒoㄒ)/~~   id: " +id;
    }
}
