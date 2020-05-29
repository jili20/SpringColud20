package com.atguigu.springcloud.alibaba.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
/**
 * @author bing  @create 2020/5/29 2:49 下午
 */
@Configuration
public class ApplicationContextConfig
{
    @Bean
    @LoadBalanced // 整合轮询负载均匀 ribbon
    public RestTemplate getRestTemplate()
    {
        return new RestTemplate();
    }
}
