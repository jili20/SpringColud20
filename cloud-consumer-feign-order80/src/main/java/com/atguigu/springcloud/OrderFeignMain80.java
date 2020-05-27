package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
/**
 * @author bing  @create 2020/5/26 3:11 下午
 */
@SpringBootApplication
@EnableFeignClients // 开启
public class OrderFeignMain80
{
    public static void main(String[] args) 
    {
        SpringApplication.run(OrderFeignMain80.class, args);
    } 
}
