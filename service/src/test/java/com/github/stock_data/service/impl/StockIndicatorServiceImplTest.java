/*
 * Copyright [rapid-framework.com]
 * Web Site: http://www.rapid-framework.com
 * Since 2005 - 2016
 */


package com.github.stock_data.service.impl;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import com.github.stock_data.StockIndicatorDataFactory;
import static junit.framework.Assert.*;
import static org.mockito.Mockito.*;

import java.util.*;

import com.github.stock_data.model.*;
import com.github.stock_data.query.*;
import com.github.stock_data.dao.*;

/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */
public class StockIndicatorServiceImplTest {

	//mock框架使用Mockito 具体使用请查看: http://code.google.com/p/mockito/wiki/MockitoVSEasyMock
	
	private StockIndicatorServiceImpl service = new StockIndicatorServiceImpl();
	private StockIndicatorDao stockIndicatorDao = mock(StockIndicatorDao.class);
	
	@Rule public TestName testName = new TestName();
	
	@Before
	public void before() {
		System.out.println("\n------------------ "+testName.getMethodName()+" ----------------------\n");
		service.setStockIndicatorDao(stockIndicatorDao);
	}
	
	@Test
	public void test_create() {
		StockIndicator obj = StockIndicatorDataFactory.newStockIndicator();
		service.create(obj);
		
		verify(stockIndicatorDao).insert(obj); //验证执行了该语句
	}
	
	@Test
	public void test_update() {
		StockIndicator obj = StockIndicatorDataFactory.newStockIndicator();
		service.update(obj);
		
		verify(stockIndicatorDao).update(obj); //验证执行了该语句
	}
	
	@Test
	public void test_removeById() {
		service.removeById(new String("1"),new String("1"),new java.util.Date("1"),new String("1"));
		
		verify(stockIndicatorDao).deleteById(new String("1"),new String("1"),new java.util.Date("1"),new String("1")); //验证执行了该语句
	}
	
	@Test
	public void test_getById() {
		when(stockIndicatorDao.getById(new String("1"),new String("1"),new java.util.Date("1"),new String("1"))).thenReturn(StockIndicatorDataFactory.newStockIndicator()); // mock方法调用
		
		StockIndicator stockIndicator = service.getById(new String("1"),new String("1"),new java.util.Date("1"),new String("1"));
		
		verify(stockIndicatorDao).getById(new String("1"),new String("1"),new java.util.Date("1"),new String("1")); //验证执行了该语句
		assertNotNull(stockIndicator);
	}
	
	
}

