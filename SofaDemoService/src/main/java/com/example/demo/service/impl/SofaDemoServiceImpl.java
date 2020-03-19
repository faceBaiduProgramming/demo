package com.example.demo.service.impl;

import com.alipay.common.tracer.core.tags.SpanTags;
import com.alipay.sofa.runtime.api.annotation.SofaService;
import com.alipay.sofa.tracer.plugin.flexible.annotations.Tracer;
import com.example.demo.service.SofaDemoService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * File: SofaDemoServiceImpl.java
 * Description: 描述信息
 * CreateTime: 2020/3/18
 *
 * @author wgaohua
 */
@Service
@SofaService
public class SofaDemoServiceImpl implements SofaDemoService {

    @Override
    public String hello(String name) {
        SpanTags.putTags("customize","customizeValue");
        return "你好！" + name;
    }

}
