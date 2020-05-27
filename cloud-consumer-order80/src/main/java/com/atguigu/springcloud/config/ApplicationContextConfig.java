package com.atguigu.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
/**
 * @author bing  @create 2020/5/24 8:59 下午
 */
@Configuration
public class ApplicationContextConfig
{
    @Bean
//    @LoadBalanced // 改用自己写的
    public RestTemplate getRestTemplate()
    {
        return new RestTemplate();
    }
}
