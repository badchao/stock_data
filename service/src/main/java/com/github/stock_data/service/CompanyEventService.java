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
 * [CompanyEvent] 的Service接口
 * 
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */
public interface CompanyEventService {

	/** 
	 * 创建CompanyEvent
	 **/
	public CompanyEvent create(CompanyEvent companyEvent);
	
	/** 
	 * 更新CompanyEvent
	 **/	
    public CompanyEvent update(CompanyEvent companyEvent);
    
    /**
     *  join取回CompanyEvent的关联信息,如一对多，多对一等的关联信息
     */
    public CompanyEvent join(CompanyEvent companyEvent);
    
	/** 
	 * 删除CompanyEvent
	 **/
    public void removeById(long id);
    
	/** 
	 * 根据ID得到CompanyEvent
	 **/    
    public CompanyEvent getById(long id);
    
	/** 
	 * 分页查询: CompanyEvent
	 **/      
	public Page<CompanyEvent> findPage(CompanyEventQuery query);
	
    
}
