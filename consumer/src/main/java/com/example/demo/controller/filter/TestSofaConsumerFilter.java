package com.example.demo.controller.filter;

import com.alipay.common.tracer.core.context.trace.SofaTraceContext;
import com.alipay.common.tracer.core.holder.SofaTraceContextHolder;
import com.alipay.common.tracer.core.span.SofaTracerSpan;
import com.alipay.sofa.rpc.core.exception.SofaRpcException;
import com.alipay.sofa.rpc.core.request.SofaRequest;
import com.alipay.sofa.rpc.core.response.SofaResponse;
import com.alipay.sofa.rpc.filter.Filter;
import com.alipay.sofa.rpc.filter.FilterInvoker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * File: TestSofaConsumerFilter.java
 * Description: 描述信息
 * CreateTime: 2020/3/20
 *
 * @author wgaohua
 */
public class TestSofaConsumerFilter extends Filter {

	@Override
	public SofaResponse invoke(FilterInvoker filterInvoker, SofaRequest sofaRequest) throws SofaRpcException {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss-Sss").format(new Date()) + "\t\tClient:调用前");
        SofaTraceContext sofaTraceContext = SofaTraceContextHolder.getSofaTraceContext();
        SofaTracerSpan sofaTracerSpan = sofaTraceContext.getCurrentSpan();
        Map<String, String> tagsStr = sofaTracerSpan.getTagsWithStr();
        tagsStr.put("ClientKey","自定义SofaRpc Client日志");
		try {
			return filterInvoker.invoke(sofaRequest);
		} finally {
            System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss-Sss").format(new Date()) + "\t\tClient:调用后");
		}
	}
}
