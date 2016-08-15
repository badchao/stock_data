/*
 * Copyright [rapid-framework.com]
 * Web Site: http://www.rapid-framework.com
 * Since 2005 - 2016
 */

package com.github.stock_data.service;

import com.github.rapid.common.util.page.Page;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.github.stock_data.model.*;
import com.github.stock_data.dao.*;
import com.github.stock_data.query.*;
import java.util.Date;

/**
 * [User] 的Service接口
 * 
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */
public interface UserService {

	/** 
	 * 创建User
	 **/
	public User create(User user);
	
	/** 
	 * 更新User
	 **/	
    public User update(User user);
    
    
    public void changePassword(String account,String newPassword,String oldPassword);
    
    /**
     *  join取回User的关联信息,如一对多，多对一等的关联信息
     */
    public User join(User user);
    
	/** 
	 * 删除User
	 **/
    public void removeById(String account);
    
	/** 
	 * 根据ID得到User
	 **/    
    public User getById(String account);
    
	/** 
	 * 分页查询: User
	 **/      
	public Page<User> findPage(UserQuery query);
	
    
}
