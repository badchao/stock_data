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
 * 用于生成Stock相关数据对象的默认值
 * 
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 * 
 */
public class StockDataFactory {
	
	public static StockQuery newStockQuery() {
		StockQuery query = new StockQuery();
		query.setPage(1);
		query.setPageSize(10);
		
	  	query.setStockId(new String("1"));
	  	query.setStockCode(new String("1"));
	  	query.setStockName(new String("1"));
	  	query.setMarket(new String("1"));
	  	query.setZone(new String("1"));
	  	query.setRemarks(new String("1"));
		return query;
	}
	
	public static Stock newStock() {
		Stock obj = new Stock();
		
	  	obj.setStockId(new String("1"));
	  	obj.setStockCode(new String("1"));
	  	obj.setStockName(new String("1"));
	  	obj.setMarket(new String("1"));
	  	obj.setZone(new String("1"));
	  	obj.setRemarks(new String("1"));
		return obj;
	}
}