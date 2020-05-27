package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.Ib.LoadBalancer;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

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

    @Resource
    private LoadBalancer loadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/consumer/payment/create") // consumer 消费者，调用 8001的 /payment/create
    public CommonResult<Payment> create(Payment payment)
    {   // 调用远方微服务用 postForObject
//        log.info("****插入结果：" ); //这里可以添加日志信息
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}") //返回json 串用对象
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id)
    {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

    @GetMapping("/consumer/payment/getForEntity/{id}") //返回更详细的信息用 Entity：比如 响应头，响应状态码，响应体等
    public CommonResult<Payment> getPayment2(@PathVariable("id") Long id)
    {
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);

        if(entity.getStatusCode().is2xxSuccessful()){
//            log.info();
            return entity.getBody();
        }else{
            return new CommonResult<>(444,"操作失败");
            // 测试：http://localhost/consumer/payment/getForEntity/1
        }
    }

    // 手写负载均衡；
    @GetMapping(value = "/consumer/payment/Ib")
    public String getPaymentLB()
    {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances == null || instances.size() <= 0) {
            return null;
        }

        ServiceInstance serviceInstance = loadBalancer.instances(instances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri + "/payment/Ib", String.class);
        // 测试： http://localhost/consumer/payment/Ib  ；看80 控制台打印内容
    }

}

