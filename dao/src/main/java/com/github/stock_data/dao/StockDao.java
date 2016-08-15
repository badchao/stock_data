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
 * tableName: stock
 * [Stock] 的Dao操作
 * 
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
*/
public interface StockDao {
	
	public void insert(Stock entity);
	
	public int update(Stock entity);

	public int deleteById(String stockId);
	
	public Stock getById(String stockId);
	

	public Page<Stock> findPage(StockQuery query);	
	
}
