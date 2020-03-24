package com.example.demo.controller.filter;

import com.alipay.common.tracer.core.context.trace.SofaTraceContext;
import com.alipay.common.tracer.core.holder.SofaTraceContextHolder;
import com.alipay.common.tracer.core.span.SofaTracerSpan;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Map;

/**
 * File: TestMvcFilter.java
 * Description: 描述信息
 * CreateTime: 2020/3/23
 *
 * @author wgaohua
 */
@WebFilter(urlPatterns = "/*")
public class TestMvcFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        SofaTraceContext sofaTraceContext = SofaTraceContextHolder.getSofaTraceContext();
        SofaTracerSpan sofaTracerSpan = sofaTraceContext.getCurrentSpan();
        Map<String, String> tagsStr = sofaTracerSpan.getTagsWithStr();
        tagsStr.put("SpringMvcKey","自定义Controller日志");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
