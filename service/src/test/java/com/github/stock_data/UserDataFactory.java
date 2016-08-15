/*
 * Copyright [rapid-framework.com]
 * Web Site: http://www.rapid-framework.com
 * Since 2005 - 2016
 */

package com.github.stock_data;

import java.util.*;

import com.github.stock_data.model.*;
import com.github.stock_data.query.*;

/**
 * 用于生成User相关数据对象的默认值
 * 
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 * 
 */
public class UserDataFactory {
	
	public static UserQuery newUserQuery() {
		UserQuery query = new UserQuery();
		query.setPage(1);
		query.setPageSize(10);
		
	  	query.setAccount(new String("1"));
	  	query.setPassword(new String("1"));
	  	query.setName(new String("1"));
	  	query.setMobile(new String("1"));
	  	query.setEmail(new String("1"));
	  	query.setRemarks(new String("1"));
	  	query.setEnabled(new Integer("1"));
		return query;
	}
	
	public static User newUser() {
		User obj = new User();
		
	  	obj.setAccount(new String("1"));
	  	obj.setPassword(new String("1"));
	  	obj.setName(new String("1"));
	  	obj.setMobile(new String("1"));
	  	obj.setEmail(new String("1"));
	  	obj.setRemarks(new String("1"));
	  	obj.setEnabled(new Integer("1"));
		return obj;
	}
}