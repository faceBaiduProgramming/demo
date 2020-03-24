package com.example.demo.controller;

import com.alipay.common.tracer.core.SofaTracer;
import com.alipay.common.tracer.core.reporter.digest.manager.SofaTracerDigestReporterAsyncManager;
import com.alipay.common.tracer.core.reporter.stat.SofaTracerStatisticReporter;
import com.alipay.common.tracer.core.reporter.stat.manager.SofaTracerStatisticReporterManager;
import com.alipay.sofa.common.utils.ReportUtil;
import com.alipay.sofa.rpc.server.rest.TraceRequestFilter;
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

    @SofaReference(interfaceType = SofaDemoService.class, jvmFirst = false, binding = @SofaReferenceBinding(bindingType = "dubbo"))
    SofaDemoService sofaDemoServiceDubbo;

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
}
