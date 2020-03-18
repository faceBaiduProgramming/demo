package com.example.demo.controller;

import com.alipay.common.tracer.core.tags.SpanTags;
import com.alipay.sofa.tracer.plugin.flexible.annotations.Tracer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * File: SofaController.java
 * Description: 描述信息
 * Company: 南威软件股份有限公司
 * CreateTime: 2020/3/17
 *
 * @author wgaohua
 */
@RestController
public class SofaController {

    @Tracer
    @RequestMapping(value = "/demo",method = RequestMethod.GET)
    public String demo(){
        return helloInner("myTracer");
    }

    /**
     * 在 hello 方法上使用 @Tracer 注解进行埋点
     * @param word
     * @return
     */
    @Tracer
    private String helloInner(String word){
        // 自定义 tag 数据
        SpanTags.putTags("手动埋点","value-1");
        return "glmapper : hello " + word;
    }

}
