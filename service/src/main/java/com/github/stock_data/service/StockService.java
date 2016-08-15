/*
 * Copyright [rapid-framework.com]
 * Web Site: http://www.rapid-framework.com
 * Since 2005 - 2016
 */

package com.github.stock_data.service;

import com.github.rapid.common.util.page.Page;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.github.stock_data.model.*;
import com.github.stock_data.dao.*;
import com.github.stock_data.query.*;
import java.util.Date;

/**
 * [Stock] 的Service接口
 * 
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */
public interface StockService {

	/** 
	 * 创建Stock
	 **/
	public Stock create(Stock stock);
	
	/** 
	 * 更新Stock
	 **/	
    public Stock update(Stock stock);
    
    /**
     *  join取回Stock的关联信息,如一对多，多对一等的关联信息
     */
    public Stock join(Stock stock);
    
	/** 
	 * 删除Stock
	 **/
    public void removeById(String stockId);
    
	/** 
	 * 根据ID得到Stock
	 **/    
    public Stock getById(String stockId);
    
	/** 
	 * 分页查询: Stock
	 **/      
	public Page<Stock> findPage(StockQuery query);
	
    
}
