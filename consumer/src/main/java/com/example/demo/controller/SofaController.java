package com.example.demo.controller;

import com.alipay.sofa.runtime.api.annotation.SofaReference;
import com.alipay.sofa.runtime.api.annotation.SofaReferenceBinding;
import com.example.demo.service.SofaDemoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

/**
 * File: SofaController.java
 * Description: 描述信息
 * CreateTime: 2020/3/17
 *
 * @author wgaohua
 */
@RestController
public class SofaController {

    @SofaReference(interfaceType = SofaDemoService.class, binding = @SofaReferenceBinding(bindingType = "bolt"))
    SofaDemoService sofaDemoServiceBolt;

    @SofaReference(interfaceType = SofaDemoService.class, binding = @SofaReferenceBinding(bindingType = "dubbo"))
    SofaDemoService sofaDemoServiceDubbo;

    @SofaReference(interfaceType = SofaDemoService.class, binding = @SofaReferenceBinding(bindingType = "h2c"))
    SofaDemoService sofaDemoServiceH2C;

    @RequestMapping(value = "/bolt",method = RequestMethod.GET)
    public String bolt(){
        String result;
        try {
            result = sofaDemoServiceBolt.hello("bolt");
        }catch (Exception e){
            e.printStackTrace();
            result = e.getMessage();
        }
        return result;
    }

    @RequestMapping(value = "/dubbo",method = RequestMethod.GET)
    public String dubbo(){
        String result;
        try {
            result = sofaDemoServiceDubbo.hello("dubbo");
        }catch (Exception e){
            e.printStackTrace();
            result = e.getMessage();
        }
        return result;
    }

    @RequestMapping(value = "/h2c",method = RequestMethod.GET)
    public String h2c(){
        String result;
        try {
            result = sofaDemoServiceH2C.hello("H2C");
        }catch (Exception e){
            e.printStackTrace();
            result = e.getMessage();
        }
        return result;
    }

}
