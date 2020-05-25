package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author bing  @create 2020/5/24 2:52 下午
 */
@Data
@AllArgsConstructor // 全参构造器
@NoArgsConstructor // 空参构造器
public class Payment implements Serializable
{
    private Long id;
    private String serial;
}