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
 * 用于生成StockIndicator相关数据对象的默认值
 * 
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 * 
 */
public class StockIndicatorDataFactory {
	
	public static StockIndicatorQuery newStockIndicatorQuery() {
		StockIndicatorQuery query = new StockIndicatorQuery();
		query.setPage(1);
		query.setPageSize(10);
		
	  	query.setStockId(new String("1"));
	  	query.setIndicatorId(new String("1"));
		query.setTdateBegin(new java.util.Date(System.currentTimeMillis()));
		query.setTdateEnd(new java.util.Date(System.currentTimeMillis()));
	  	query.setTdateType(new String("1"));
	  	query.setVal(new Float("1"));
	  	query.setExt(new String("1"));
		return query;
	}
	
	public static StockIndicator newStockIndicator() {
		StockIndicator obj = new StockIndicator();
		
	  	obj.setStockId(new String("1"));
	  	obj.setIndicatorId(new String("1"));
	  	obj.setTdate(new java.util.Date(System.currentTimeMillis()));
	  	obj.setTdateType(new String("1"));
	  	obj.setVal(new java.lang.Float("1"));
	  	obj.setExt(new String("1"));
		return obj;
	}
}