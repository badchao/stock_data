/*
 * Copyright [rapid-framework.com]
 * Web Site: http://www.rapid-framework.com
 * Since 2005 - 2016
 */

package com.github.stock_data.dao;

import com.github.stock_data.model.*;
import com.github.stock_data.query.*;

import java.util.List;

import com.github.rapid.common.util.page.Page;

/**
 * tableName: user
 * [User] 的Dao操作
 * 
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
*/
public interface UserDao {
	
	public void insert(User entity);
	
	public int update(User entity);

	public int updatePassword(User entity);
		
	public int deleteById(String account);
	
	public User getById(String account);
	

	public Page<User> findPage(UserQuery query);	
	
}
