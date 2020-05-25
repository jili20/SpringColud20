package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;
/**
 * @author bing  @create 2020/5/24 8:44 下午
 */
@RestController
@Slf4j
public class OrderController
{
//    public static final String PAYMENT_URL = "http://localhost:8001";// 单机
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE"; // 集群
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create") // consumer 消费者，调用 8001的 /payment/create
    public CommonResult<Payment> create(Payment payment)
    {   // 调用远方微服务用 postForObject
//        log.info("****插入结果：" ); //这里可以添加日志信息
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id)
    {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }
}
