package com.example.demo.service.impl;

import com.example.demo.service.SofaDemoService;

/**
 * File: SofaDemoServiceImpl.java
 * Description: 描述信息
 * CreateTime: 2020/3/18
 *
 * @author wgaohua
 */
public class SofaDemoServiceImpl implements SofaDemoService {

    @Override
    public String hello(String name) {
        return "你好！" + name;
    }

}
