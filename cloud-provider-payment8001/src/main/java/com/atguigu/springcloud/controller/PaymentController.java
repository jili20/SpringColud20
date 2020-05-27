package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;
/**
 * @author bing  @create 2020/5/24 2:57 下午
 */
@RestController
@Slf4j
public class PaymentController
{
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment)
    {
        int result = paymentService.create(payment);
        log.info("****插入结果：" + result);  // idea安装Lombok插件p j
        if (result > 0)
        {
            return new CommonResult(200, "插入数据库成功,serverPort:" + serverPort, result);
        }else {
            return new CommonResult(444, "插入数据库失败", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id)
    {
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****插入结果：" + payment);
        if (payment != null)
        {
            return new CommonResult(200, "查询成功,serverPort:" + serverPort, payment);
        }else {
            return new CommonResult(444, "没有对应记录，查询ID：" + id, null);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery()
    {
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("*****element:" + element);//注册登录过的微服务列表清单 Application 列
        }
        //获取 CLOUD-PAYMENT-SERVICE 微服务下面的全部实例
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }

    // 手写一个本地负载均衡器
    @GetMapping(value = "/payment/lb")
    public String getPaymentLB()
    {
        return serverPort;
    }

    //故意设置超时演示出错情况
    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout()
    {
        try {
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        return serverPort;
    }

}