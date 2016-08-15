/*
 * Copyright [rapid-framework.com]
 * Web Site: http://www.rapid-framework.com
 * Since 2005 - 2016
 */

package com.github.stock_data.dao;

import com.github.stock_data.model.*;
import com.github.stock_data.query.*;

import java.util.List;
import com.github.rapid.common.util.page.Page;

/**
 * tableName: stock_indicator_config
 * [StockIndicatorConfig] 的Dao操作
 * 
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
*/
public interface StockIndicatorConfigDao {
	
	public void insert(StockIndicatorConfig entity);
	
	public int update(StockIndicatorConfig entity);

	public int deleteById(String stockId, String indicatorId);
	
	public StockIndicatorConfig getById(String stockId, String indicatorId);
	

	public Page<StockIndicatorConfig> findPage(StockIndicatorConfigQuery query);	
	
}
