package com.example.demo.controller;

import com.alipay.common.tracer.core.tags.SpanTags;
import com.alipay.sofa.runtime.api.annotation.SofaReference;
import com.alipay.sofa.tracer.plugin.flexible.annotations.Tracer;
import com.example.demo.service.SofaDemoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * File: SofaController.java
 * Description: 描述信息
 * CreateTime: 2020/3/17
 *
 * @author wgaohua
 */
@RestController
public class SofaController {

    @SofaReference
    SofaDemoService sofaDemoService;

    @RequestMapping(value = "/sofaDemo",method = RequestMethod.GET)
    public String sofaDemo(String name){
        return sofaDemoService.hello(name);
    }

}
