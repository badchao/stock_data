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

import com.github.stock_data.StockIndicatorConfigDataFactory;
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
public class StockIndicatorConfigServiceImplTest {

	//mock框架使用Mockito 具体使用请查看: http://code.google.com/p/mockito/wiki/MockitoVSEasyMock
	
	private StockIndicatorConfigServiceImpl service = new StockIndicatorConfigServiceImpl();
	private StockIndicatorConfigDao stockIndicatorConfigDao = mock(StockIndicatorConfigDao.class);
	
	@Rule public TestName testName = new TestName();
	
	@Before
	public void before() {
		System.out.println("\n------------------ "+testName.getMethodName()+" ----------------------\n");
		service.setStockIndicatorConfigDao(stockIndicatorConfigDao);
	}
	
	@Test
	public void test_create() {
		StockIndicatorConfig obj = StockIndicatorConfigDataFactory.newStockIndicatorConfig();
		service.create(obj);
		
		verify(stockIndicatorConfigDao).insert(obj); //验证执行了该语句
	}
	
	@Test
	public void test_update() {
		StockIndicatorConfig obj = StockIndicatorConfigDataFactory.newStockIndicatorConfig();
		service.update(obj);
		
		verify(stockIndicatorConfigDao).update(obj); //验证执行了该语句
	}
	
	@Test
	public void test_removeById() {
		service.removeById(new String("1"),new String("1"));
		
		verify(stockIndicatorConfigDao).deleteById(new String("1"),new String("1")); //验证执行了该语句
	}
	
	@Test
	public void test_getById() {
		when(stockIndicatorConfigDao.getById(new String("1"),new String("1"))).thenReturn(StockIndicatorConfigDataFactory.newStockIndicatorConfig()); // mock方法调用
		
		StockIndicatorConfig stockIndicatorConfig = service.getById(new String("1"),new String("1"));
		
		verify(stockIndicatorConfigDao).getById(new String("1"),new String("1")); //验证执行了该语句
		assertNotNull(stockIndicatorConfig);
	}
	
	
}

