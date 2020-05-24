package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author bing  @create 2020/5/24 2:56 下午
 */
@Service
public class PaymentServiceImpl implements PaymentService
{
    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment)//写操作，插入
    {
        return paymentDao.create(payment);
    }

    public Payment getPaymentById(Long id)// 读操作
    {
        return paymentDao.getPaymentById(id);
    }
}