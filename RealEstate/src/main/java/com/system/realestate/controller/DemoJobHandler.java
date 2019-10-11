package com.system.realestate.controller;





import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;

@JobHandler(value="DemoJobHandler")
@Component
public class DemoJobHandler extends IJobHandler{
	
	private static Logger logger = LoggerFactory.getLogger(DemoJobHandler.class);
	@Override
	public ReturnT<String> execute(String param) throws Exception {
		logger.info("Hello World!");
		return SUCCESS;
	}
	
	
}
