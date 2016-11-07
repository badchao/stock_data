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

import com.github.stock_data.CompanyEventDataFactory;
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
public class CompanyEventServiceImplTest {

	//mock框架使用Mockito 具体使用请查看: http://code.google.com/p/mockito/wiki/MockitoVSEasyMock
	
	private CompanyEventServiceImpl service = new CompanyEventServiceImpl();
	private CompanyEventDao companyEventDao = mock(CompanyEventDao.class);
	
	@Rule public TestName testName = new TestName();
	
	@Before
	public void before() {
		System.out.println("\n------------------ "+testName.getMethodName()+" ----------------------\n");
		service.setCompanyEventDao(companyEventDao);
	}
	
	@Test
	public void test_create() {
		CompanyEvent obj = CompanyEventDataFactory.newCompanyEvent();
		service.create(obj);
		
		verify(companyEventDao).insert(obj); //验证执行了该语句
	}
	
	@Test
	public void test_update() {
		CompanyEvent obj = CompanyEventDataFactory.newCompanyEvent();
		service.update(obj);
		
		verify(companyEventDao).update(obj); //验证执行了该语句
	}
	
	@Test
	public void test_removeById() {
		service.removeById(new Long("1"));
		
		verify(companyEventDao).deleteById(new Long("1")); //验证执行了该语句
	}
	
	@Test
	public void test_getById() {
		when(companyEventDao.getById(new Long("1"))).thenReturn(CompanyEventDataFactory.newCompanyEvent()); // mock方法调用
		
		CompanyEvent companyEvent = service.getById(new Long("1"));
		
		verify(companyEventDao).getById(new Long("1")); //验证执行了该语句
		assertNotNull(companyEvent);
	}
	
	
}

