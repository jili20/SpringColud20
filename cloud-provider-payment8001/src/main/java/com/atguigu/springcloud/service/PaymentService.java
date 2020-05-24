package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author bing  @create 2020/5/24 2:56 下午
 */
public interface PaymentService
{
    public int create(Payment payment);//写操作，插入

    public Payment getPaymentById(@Param("id") Long id);// 读操作
}