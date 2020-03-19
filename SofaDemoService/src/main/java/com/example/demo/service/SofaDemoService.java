package com.example.demo.service;

import com.alipay.sofa.tracer.plugin.flexible.annotations.Tracer;

/**
 * File: SofaDemoService.java
 * Description: 描述信息
 * CreateTime: 2020/3/18
 *
 * @author wgaohua
 */
public interface SofaDemoService {

    /**
     * hello
     * @param name
     * @return
     */
    @Tracer
    String hello(String name);
}
