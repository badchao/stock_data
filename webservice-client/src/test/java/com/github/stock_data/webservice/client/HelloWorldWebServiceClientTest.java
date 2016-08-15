package com.github.stock_data.webservice.client;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.stock_data.webservice.HelloWorldWebService;


public class HelloWorldWebServiceClientTest {

	@Test
	public void test() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/*.xml");
		HelloWorldWebService helloWorldWebService = ctx.getBean(HelloWorldWebService.class);
		System.out.println(helloWorldWebService.hello("badqiu"));
		
	}
}
