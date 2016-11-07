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
 * 用于生成CompanyEvent相关数据对象的默认值
 * 
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 * 
 */
public class CompanyEventDataFactory {
	
	public static CompanyEventQuery newCompanyEventQuery() {
		CompanyEventQuery query = new CompanyEventQuery();
		query.setPage(1);
		query.setPageSize(10);
		
	  	query.setId(new Long("1"));
		query.setTdateBegin(new java.util.Date(System.currentTimeMillis()));
		query.setTdateEnd(new java.util.Date(System.currentTimeMillis()));
	  	query.setCompanyName(new String("1"));
	  	query.setStockEvent(new String("1"));
	  	query.setRelateCompany(new String("1"));
	  	query.setRemarks(new String("1"));
		query.setAttentionDateBegin(new java.util.Date(System.currentTimeMillis()));
		query.setAttentionDateEnd(new java.util.Date(System.currentTimeMillis()));
	  	query.setRelateStock(new String("1"));
		return query;
	}
	
	public static CompanyEvent newCompanyEvent() {
		CompanyEvent obj = new CompanyEvent();
		
	  	obj.setId(new Long("1"));
	  	obj.setTdate(new java.util.Date(System.currentTimeMillis()));
	  	obj.setCompanyName(new String("1"));
	  	obj.setStockEvent(new String("1"));
	  	obj.setRelateCompany(new String("1"));
	  	obj.setRemarks(new String("1"));
	  	obj.setAttentionDate(new java.util.Date(System.currentTimeMillis()));
	  	obj.setRelateStock(new String("1"));
		return obj;
	}
}