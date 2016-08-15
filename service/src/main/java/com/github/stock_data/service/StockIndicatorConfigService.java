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
 * [StockIndicatorConfig] 的Service接口
 * 
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */
public interface StockIndicatorConfigService {

	/** 
	 * 创建StockIndicatorConfig
	 **/
	public StockIndicatorConfig create(StockIndicatorConfig stockIndicatorConfig);
	
	/** 
	 * 更新StockIndicatorConfig
	 **/	
    public StockIndicatorConfig update(StockIndicatorConfig stockIndicatorConfig);
    
    /**
     *  join取回StockIndicatorConfig的关联信息,如一对多，多对一等的关联信息
     */
    public StockIndicatorConfig join(StockIndicatorConfig stockIndicatorConfig);
    
	/** 
	 * 删除StockIndicatorConfig
	 **/
    public void removeById(String stockId, String indicatorId);
    
	/** 
	 * 根据ID得到StockIndicatorConfig
	 **/    
    public StockIndicatorConfig getById(String stockId, String indicatorId);
    
	/** 
	 * 分页查询: StockIndicatorConfig
	 **/      
	public Page<StockIndicatorConfig> findPage(StockIndicatorConfigQuery query);
	
    
}
