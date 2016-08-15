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
 * 用于生成StockIndicatorConfig相关数据对象的默认值
 * 
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 * 
 */
public class StockIndicatorConfigDataFactory {
	
	public static StockIndicatorConfigQuery newStockIndicatorConfigQuery() {
		StockIndicatorConfigQuery query = new StockIndicatorConfigQuery();
		query.setPage(1);
		query.setPageSize(10);
		
	  	query.setStockId(new String("1"));
	  	query.setIndicatorId(new String("1"));
	  	query.setIndicatorName(new String("1"));
	  	query.setCrawlUrl(new String("1"));
	  	query.setCrawlScript(new String("1"));
	  	query.setCrawlCron(new String("1"));
	  	query.setCalcExpr(new String("1"));
	  	query.setRemarks(new String("1"));
		return query;
	}
	
	public static StockIndicatorConfig newStockIndicatorConfig() {
		StockIndicatorConfig obj = new StockIndicatorConfig();
		
	  	obj.setStockId(new String("1"));
	  	obj.setIndicatorId(new String("1"));
	  	obj.setIndicatorName(new String("1"));
	  	obj.setCrawlUrl(new String("1"));
	  	obj.setCrawlScript(new String("1"));
	  	obj.setCrawlCron(new String("1"));
	  	obj.setCalcExpr(new String("1"));
	  	obj.setRemarks(new String("1"));
		return obj;
	}
}