/*
 * Copyright [rapid-framework.com]
 * Web Site: http://www.rapid-framework.com
 * Since 2005 - 2016
 */

package com.github.stock_data.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.github.stock_data.service.UserService;
import com.github.rapid.common.util.holder.BeanValidatorHolder;
import com.github.rapid.common.util.page.Page;
import com.github.stock_data.model.*;
import com.github.stock_data.common.util.SecurityUtil;
import com.github.stock_data.dao.*;
import com.github.stock_data.query.*;

import java.util.Date;

/**
 * [User] 的Service接口实现
 * 
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	protected static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	/*
	* 请删除无用的方法，本代码生成器的理念是: 1. 一次生成，后期手工修改代码 2. 删除代码比手写重复代码快捷，所以请删除无用代码
	*/
	
	private UserDao userDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setUserDao(UserDao dao) {
		this.userDao = dao;
	}
	
	/** 
	 * 创建User
	 **/
	public User create(User user) {
	    Assert.notNull(user,"'user' must be not null");
	    initDefaultValuesForCreate(user);
	    new UserChecker().checkCreateUser(user);
	    userDao.insert(user);
	    return user;
	}
	
	/** 
	 * 更新User
	 **/	
    public User update(User user) {
        Assert.notNull(user,"'user' must be not null");
        new UserChecker().checkUpdateUser(user);
        userDao.update(user);
        return user;
    }	
    
    /**
     *  join取回User的关联信息,如一对多，多对一等的关联信息
     */
    public User join(User user) {
    	return user;
    }
    
	/** 
	 * 删除User
	 **/
    public void removeById(String account) {
        userDao.deleteById(account);
    }
    
	/** 
	 * 根据ID得到User
	 **/    
    public User getById(String account) {
        return userDao.getById(account);
    }
    
	/** 
	 * 分页查询: User
	 **/      
	@Transactional(readOnly=true)
	public Page<User> findPage(UserQuery query) {
	    Assert.notNull(query,"'query' must be not null");
		return userDao.findPage(query);
	}
	
    
	/**
	 * 创建对象时初始化相关默认值 
	 **/
    public void initDefaultValuesForCreate(User user) {
    	Assert.hasText(user.getPassword(),"password must be not empty");
    	String finalPassword = SecurityUtil.getMd5Password(user.getPassword());
    	user.setPassword(finalPassword);
    	
    }
    
    /**
     * User的属性检查类,根据自己需要编写自定义检查
     **/
    public class UserChecker {
        /**可以在此检查只有更新才需要的特殊检查 */
        public void checkUpdateUser(User user) {
            checkUser(user);
        }
    
        /**可以在此检查只有创建才需要的特殊检查 */
        public void checkCreateUser(User user) {
            checkUser(user);
        }
        
        /** 检查到有错误请直接抛异常，不要使用 return errorCode的方式 */
        public void checkUser(User user) {
        	// Bean Validator检查,属性检查失败将抛异常
        	BeanValidatorHolder.validateWithException(user);
            
        	//复杂的属性的检查一般需要分开写几个方法，如 checkProperty1(v),checkProperty2(v)
        }
    }

	@Override
	public void changePassword(String account, String newPassword,
			String oldPassword) {
		User user = getById(account);
		String oldMd5 = SecurityUtil.getMd5Password(oldPassword);
		if(!oldMd5.equals(user.getPassword())) {
			throw new SecurityException("old password error");
		}
		
		String newMd5 = SecurityUtil.getMd5Password(newPassword);
		user.setPassword(newMd5);
		userDao.updatePassword(user);
	}
}
