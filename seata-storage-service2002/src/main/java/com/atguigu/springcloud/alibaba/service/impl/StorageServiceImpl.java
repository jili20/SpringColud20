package com.atguigu.springcloud.alibaba.service.impl;

import com.atguigu.springcloud.alibaba.dao.StorageDao;
import com.atguigu.springcloud.alibaba.service.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
/**
 * @author bing  @create 2020/6/2 7:57 下午
 */
@Service
public class StorageServiceImpl implements StorageService
{
    private static final Logger logger = LoggerFactory.getLogger(StorageServiceImpl.class);

    @Resource
    private StorageDao storageDao;

    /**
     * 扣减库存
     */
    @Override
    public void decrease(Long productId, Integer count) {
        logger.info("------> storage-service 中扣减库存开始");
        storageDao.decrease(productId,count);
        logger.info("------> storage-service 中扣减库存结束");
    }
}
