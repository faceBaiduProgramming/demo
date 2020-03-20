package com.example.demo.service.config;

import com.alipay.sofa.rpc.core.exception.SofaRpcException;
import com.alipay.sofa.rpc.core.request.SofaRequest;
import com.alipay.sofa.rpc.core.response.SofaResponse;
import com.alipay.sofa.rpc.filter.Filter;
import com.alipay.sofa.rpc.filter.FilterInvoker;
import com.alipay.sofa.rpc.log.Logger;
import com.alipay.sofa.rpc.log.LoggerFactory;

/**
 * File: TestSofaFilter.java
 * Description: 描述信息
 * Company: 南威软件股份有限公司
 * CreateTime: 2020/3/20
 *
 * @author wgaohua
 */
public class TestSofaFilter extends Filter {

	private static final Logger logger = LoggerFactory.getLogger(TestSofaFilter.class);

	@Override
	public SofaResponse invoke(FilterInvoker filterInvoker, SofaRequest sofaRequest) throws SofaRpcException {
		logger.info("client:调用Service前");
		try {
			return filterInvoker.invoke(sofaRequest);
		} finally {
			logger.info("client:调用Service后");
		}

	}
}
