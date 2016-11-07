/*
 * Copyright [rapid-framework.com]
 * Web Site: http://www.rapid-framework.com
 * Since 2005 - 2016
 */

package com.github.stock_data.dao;

import com.github.stock_data.model.*;
import com.github.stock_data.query.*;

import java.util.*;
import com.github.rapid.common.util.page.Page;

/**
 * tableName: company_event
 * [CompanyEvent] 的Dao操作
 * 
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
*/
public interface CompanyEventDao {
	
	public void insert(CompanyEvent entity);
	
	public int update(CompanyEvent entity);

	public int deleteById(long id);
	
	public CompanyEvent getById(long id);
	

	public Page<CompanyEvent> findPage(CompanyEventQuery query);	
	
}
