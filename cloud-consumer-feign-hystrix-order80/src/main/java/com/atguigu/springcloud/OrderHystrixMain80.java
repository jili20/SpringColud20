package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
/**
 * @author bing  @create 2020/5/26 8:06 下午
 */
@SpringBootApplication
@EnableFeignClients // 激活Feign
@EnableHystrix // 激活回路
public class OrderHystrixMain80 
{
    public static void main(String[] args) 
    {
        SpringApplication.run(OrderHystrixMain80.class, args);
    } 
    
}
