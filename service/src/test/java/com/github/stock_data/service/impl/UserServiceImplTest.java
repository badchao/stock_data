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

import com.github.stock_data.UserDataFactory;
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
public class UserServiceImplTest {

	//mock框架使用Mockito 具体使用请查看: http://code.google.com/p/mockito/wiki/MockitoVSEasyMock
	
	private UserServiceImpl service = new UserServiceImpl();
	private UserDao userDao = mock(UserDao.class);
	
	@Rule public TestName testName = new TestName();
	
	@Before
	public void before() {
		System.out.println("\n------------------ "+testName.getMethodName()+" ----------------------\n");
		service.setUserDao(userDao);
	}
	
	@Test
	public void test_create() {
		User obj = UserDataFactory.newUser();
		service.create(obj);
		
		verify(userDao).insert(obj); //验证执行了该语句
	}
	
	@Test
	public void test_update() {
		User obj = UserDataFactory.newUser();
		service.update(obj);
		
		verify(userDao).update(obj); //验证执行了该语句
	}
	
	@Test
	public void test_removeById() {
		service.removeById(new String("1"));
		
		verify(userDao).deleteById(new String("1")); //验证执行了该语句
	}
	
	@Test
	public void test_getById() {
		when(userDao.getById(new String("1"))).thenReturn(UserDataFactory.newUser()); // mock方法调用
		
		User user = service.getById(new String("1"));
		
		verify(userDao).getById(new String("1")); //验证执行了该语句
		assertNotNull(user);
	}
	
	
}

