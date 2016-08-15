package com.github.stock_data.webservice;

import com.github.stock_data.webservice.dto.HelloDTO;

public interface HelloWorldWebService {

	/**
	 * 调用示例: http://localhost:6060/rpc/HelloWorldWebService/hello?name=badqiu
	 */
	public String hello(String name);
	
	/**
	 * 调用示例: http://localhost:6060/rpc/HelloWorldWebService/echo?name=badqiu&sex=m&age=22
	 */
	public String echo(HelloDTO bean);
	
}
