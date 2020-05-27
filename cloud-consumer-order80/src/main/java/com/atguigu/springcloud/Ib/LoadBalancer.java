package com.atguigu.springcloud.Ib;

import org.springframework.cloud.client.ServiceInstance;
import java.util.List;
/**
 * @author bing  @create 2020/5/26 1:18 下午
 */
public interface LoadBalancer
{
    ServiceInstance instances(List<ServiceInstance> serviceInstance); // 能提供服务的机器总数
}
