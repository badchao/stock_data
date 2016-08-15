/*
 * Copyright [rapid-framework.com]
 * Web Site: http://www.rapid-framework.com
 * Since 2005 - 2016
 */

package com.github.stock_data.dao;

import java.util.Date;

import com.github.rapid.common.util.page.Page;
import com.github.stock_data.model.DwStock;
import com.github.stock_data.query.DwStockQuery;

/**
 * tableName: dw_stock
 * [DwStock] 的Dao操作
 * 
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
*/
public interface DwStockDao {
	
	public void insert(DwStock entity);
	
	public int update(DwStock entity);

	public int deleteById(String stockId, Date tdate, String tdateType);
	
	public DwStock getById(String stockId, Date tdate, String tdateType);
	

	public Page<DwStock> findPage(DwStockQuery query);	
	
}
