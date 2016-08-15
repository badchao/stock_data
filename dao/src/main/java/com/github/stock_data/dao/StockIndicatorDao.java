/*
 * Copyright [rapid-framework.com]
 * Web Site: http://www.rapid-framework.com
 * Since 2005 - 2016
 */

package com.github.stock_data.dao;

import java.util.Date;

import com.github.rapid.common.util.page.Page;
import com.github.stock_data.model.StockIndicator;
import com.github.stock_data.query.StockIndicatorQuery;

/**
 * tableName: stock_indicator
 * [StockIndicator] 的Dao操作
 * 
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
*/
public interface StockIndicatorDao {
	
	public void insert(StockIndicator entity);
	
	public int update(StockIndicator entity);

	public int deleteById(String stockId, String indicatorId, Date tdate, String tdateType);
	
	public StockIndicator getById(String stockId, String indicatorId, Date tdate, String tdateType);
	

	public Page<StockIndicator> findPage(StockIndicatorQuery query);	
	
}
