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

import com.github.stock_data.DwStockDataFactory;
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
public class DwStockServiceImplTest {

	//mock框架使用Mockito 具体使用请查看: http://code.google.com/p/mockito/wiki/MockitoVSEasyMock
	
	private DwStockServiceImpl service = new DwStockServiceImpl();
	private DwStockDao dwStockDao = mock(DwStockDao.class);
	
	@Rule public TestName testName = new TestName();
	
	@Before
	public void before() {
		System.out.println("\n------------------ "+testName.getMethodName()+" ----------------------\n");
		service.setDwStockDao(dwStockDao);
	}
	
	@Test
	public void test_create() {
		DwStock obj = DwStockDataFactory.newDwStock();
		service.create(obj);
		
		verify(dwStockDao).insert(obj); //验证执行了该语句
	}
	
	@Test
	public void test_update() {
		DwStock obj = DwStockDataFactory.newDwStock();
		service.update(obj);
		
		verify(dwStockDao).update(obj); //验证执行了该语句
	}
	
	@Test
	public void test_removeById() {
		service.removeById(new String("1"),new java.util.Date("1"),new String("1"));
		
		verify(dwStockDao).deleteById(new String("1"),new java.util.Date("1"),new String("1")); //验证执行了该语句
	}
	
	@Test
	public void test_getById() {
		when(dwStockDao.getById(new String("1"),new java.util.Date("1"),new String("1"))).thenReturn(DwStockDataFactory.newDwStock()); // mock方法调用
		
		DwStock dwStock = service.getById(new String("1"),new java.util.Date("1"),new String("1"));
		
		verify(dwStockDao).getById(new String("1"),new java.util.Date("1"),new String("1")); //验证执行了该语句
		assertNotNull(dwStock);
	}
	
	
}

