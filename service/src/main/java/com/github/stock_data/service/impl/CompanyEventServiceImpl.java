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

import com.github.stock_data.service.CompanyEventService;

import com.github.rapid.common.util.holder.BeanValidatorHolder;
import com.github.rapid.common.util.page.Page;

import com.github.stock_data.model.*;
import com.github.stock_data.dao.*;
import com.github.stock_data.query.*;
import java.util.Date;

/**
 * [CompanyEvent] 的Service接口实现
 * 
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */
@Service("companyEventService")
@Transactional
public class CompanyEventServiceImpl implements CompanyEventService {

	protected static final Logger logger = LoggerFactory.getLogger(CompanyEventServiceImpl.class);
	
	/*
	* 请删除无用的方法，本代码生成器的理念是: 1. 一次生成，后期手工修改代码 2. 删除代码比手写重复代码快捷，所以请删除无用代码
	*/
	
	private CompanyEventDao companyEventDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setCompanyEventDao(CompanyEventDao dao) {
		this.companyEventDao = dao;
	}
	
	/** 
	 * 创建CompanyEvent
	 **/
	public CompanyEvent create(CompanyEvent companyEvent) {
	    Assert.notNull(companyEvent,"'companyEvent' must be not null");
	    initDefaultValuesForCreate(companyEvent);
	    new CompanyEventChecker().checkCreateCompanyEvent(companyEvent);
	    companyEventDao.insert(companyEvent);
	    return companyEvent;
	}
	
	/** 
	 * 更新CompanyEvent
	 **/	
    public CompanyEvent update(CompanyEvent companyEvent) {
        Assert.notNull(companyEvent,"'companyEvent' must be not null");
        new CompanyEventChecker().checkUpdateCompanyEvent(companyEvent);
        companyEventDao.update(companyEvent);
        return companyEvent;
    }	
    
    /**
     *  join取回CompanyEvent的关联信息,如一对多，多对一等的关联信息
     */
    public CompanyEvent join(CompanyEvent companyEvent) {
    	return companyEvent;
    }
    
	/** 
	 * 删除CompanyEvent
	 **/
    public void removeById(long id) {
        companyEventDao.deleteById(id);
    }
    
	/** 
	 * 根据ID得到CompanyEvent
	 **/    
    public CompanyEvent getById(long id) {
        return companyEventDao.getById(id);
    }
    
	/** 
	 * 分页查询: CompanyEvent
	 **/      
	@Transactional(readOnly=true)
	public Page<CompanyEvent> findPage(CompanyEventQuery query) {
	    Assert.notNull(query,"'query' must be not null");
		return companyEventDao.findPage(query);
	}
	
    
	/**
	 * 创建对象时初始化相关默认值 
	 **/
    public void initDefaultValuesForCreate(CompanyEvent companyEvent) {
    }
    
    /**
     * CompanyEvent的属性检查类,根据自己需要编写自定义检查
     **/
    public class CompanyEventChecker {
        /**可以在此检查只有更新才需要的特殊检查 */
        public void checkUpdateCompanyEvent(CompanyEvent companyEvent) {
            checkCompanyEvent(companyEvent);
        }
    
        /**可以在此检查只有创建才需要的特殊检查 */
        public void checkCreateCompanyEvent(CompanyEvent companyEvent) {
            checkCompanyEvent(companyEvent);
        }
        
        /** 检查到有错误请直接抛异常，不要使用 return errorCode的方式 */
        public void checkCompanyEvent(CompanyEvent companyEvent) {
        	// Bean Validator检查,属性检查失败将抛异常
        	BeanValidatorHolder.validateWithException(companyEvent);
            
        	//复杂的属性的检查一般需要分开写几个方法，如 checkProperty1(v),checkProperty2(v)
        }
    }
}
