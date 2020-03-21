package com.example.demo.controller.filter;

import com.alipay.sofa.rpc.core.exception.SofaRpcException;
import com.alipay.sofa.rpc.core.request.SofaRequest;
import com.alipay.sofa.rpc.core.response.SofaResponse;
import com.alipay.sofa.rpc.filter.Filter;
import com.alipay.sofa.rpc.filter.FilterInvoker;
import com.alipay.sofa.rpc.log.Logger;
import com.alipay.sofa.rpc.log.LoggerFactory;
import org.apache.http.client.utils.DateUtils;

import java.util.Date;

/**
 * File: TestSofaFilter.java
 * Description: 描述信息
 * CreateTime: 2020/3/20
 *
 * @author wgaohua
 */
public class TestSofaFilter extends Filter {

	private static final Logger logger = LoggerFactory.getLogger(TestSofaFilter.class);

	@Override
	public SofaResponse invoke(FilterInvoker filterInvoker, SofaRequest sofaRequest) throws SofaRpcException {
        System.out.println(DateUtils.formatDate(new Date(),"yyyy-MM-dd HH:mm:ss Sss") + "\t\tclient:调用Service前");
		try {
			return filterInvoker.invoke(sofaRequest);
		} finally {
            System.out.println(DateUtils.formatDate(new Date(),"yyyy-MM-dd HH:mm:ss Sss") + "\t\tclient:调用Service后");
		}
	}
}
