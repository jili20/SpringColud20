package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author bing  @create 2020/5/24 2:53 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult <T>
{
    private Integer code;
    private String  message;
    private T       data;

    public CommonResult(Integer code,String message)
    {
        this(code,message,null); // idea安装 Lombok 插件解决这里报错。
    }
}