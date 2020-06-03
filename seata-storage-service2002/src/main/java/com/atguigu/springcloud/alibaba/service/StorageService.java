package com.atguigu.springcloud.alibaba.service;

/**
 * @author bing  @create 2020/6/2 7:56 下午
 */
public interface StorageService {
    /**
     * 扣减库存
     */
    void decrease(Long productId, Integer count);
}
