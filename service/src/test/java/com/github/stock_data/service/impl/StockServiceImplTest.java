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

import com.github.stock_data.StockDataFactory;
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
public class StockServiceImplTest {

	//mock框架使用Mockito 具体使用请查看: http://code.google.com/p/mockito/wiki/MockitoVSEasyMock
	
	private StockServiceImpl service = new StockServiceImpl();
	private StockDao stockDao = mock(StockDao.class);
	
	@Rule public TestName testName = new TestName();
	
	@Before
	public void before() {
		System.out.println("\n------------------ "+testName.getMethodName()+" ----------------------\n");
		service.setStockDao(stockDao);
	}
	
	@Test
	public void test_create() {
		Stock obj = StockDataFactory.newStock();
		service.create(obj);
		
		verify(stockDao).insert(obj); //验证执行了该语句
	}
	
	@Test
	public void test_update() {
		Stock obj = StockDataFactory.newStock();
		service.update(obj);
		
		verify(stockDao).update(obj); //验证执行了该语句
	}
	
	@Test
	public void test_removeById() {
		service.removeById(new String("1"));
		
		verify(stockDao).deleteById(new String("1")); //验证执行了该语句
	}
	
	@Test
	public void test_getById() {
		when(stockDao.getById(new String("1"))).thenReturn(StockDataFactory.newStock()); // mock方法调用
		
		Stock stock = service.getById(new String("1"));
		
		verify(stockDao).getById(new String("1")); //验证执行了该语句
		assertNotNull(stock);
	}
	
	
}

