package com.github.stock_data.webservice.impl;

import com.github.stock_data.webservice.HelloWorldWebService;
import com.github.stock_data.webservice.dto.HelloDTO;

public class HelloWorldWebServiceImpl implements HelloWorldWebService{

	private int count = 0;
	@Override
	public String hello(String name) {
		count++;
		System.out.println(count + ". hello,name:" + name);
		return count + ". hello:" + name;
	}
	
	@Override
	public String echo(HelloDTO bean) {
		count++;
		System.out.println(count + ". echo:"+bean);
		return bean.toString();
	}

}
