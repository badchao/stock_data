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
 * 用于生成DwStock相关数据对象的默认值
 * 
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 * 
 */
public class DwStockDataFactory {
	
	public static DwStockQuery newDwStockQuery() {
		DwStockQuery query = new DwStockQuery();
		query.setPage(1);
		query.setPageSize(10);
		
	  	query.setStockId(new String("1"));
		query.setTdateBegin(new java.util.Date(System.currentTimeMillis()));
		query.setTdateEnd(new java.util.Date(System.currentTimeMillis()));
	  	query.setTdateType(new String("1"));
	  	query.setPe(new Float("1"));
	  	query.setPb(new Float("1"));
	  	query.setReverce(new Float("1"));
	  	query.setCompanyValue(new Float("1"));
		return query;
	}
	
	public static DwStock newDwStock() {
		DwStock obj = new DwStock();
		
	  	obj.setStockId(new String("1"));
	  	obj.setTdate(new java.util.Date(System.currentTimeMillis()));
	  	obj.setTdateType(new String("1"));
	  	obj.setPe(new java.lang.Float("1"));
	  	obj.setPb(new java.lang.Float("1"));
	  	obj.setReverce(new java.lang.Float("1"));
	  	obj.setCompanyValue(new java.lang.Float("1"));
		return obj;
	}
}