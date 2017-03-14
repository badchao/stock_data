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
 * [StockIndicator] 的Service接口
 * 
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */
public interface StockIndicatorService {

	/** 
	 * 创建StockIndicator
	 **/
	public StockIndicator create(StockIndicator stockIndicator);
	
	/** 
	 * 更新StockIndicator
	 **/	
    public StockIndicator update(StockIndicator stockIndicator);
    
    /**
     *  join取回StockIndicator的关联信息,如一对多，多对一等的关联信息
     */
    public StockIndicator join(StockIndicator stockIndicator);
    
	/** 
	 * 删除StockIndicator
	 **/
    public void removeById(String stockId, String indicatorId, Date tdate, String tdateType);
    
	/** 
	 * 根据ID得到StockIndicator
	 **/    
    public StockIndicator getById(String stockId, String indicatorId, Date tdate, String tdateType);
    
	/** 
	 * 分页查询: StockIndicator
	 **/      
	public Page<StockIndicator> findPage(StockIndicatorQuery query);

	public void deleteBy(String stockId, String indicatorId);
	
    
}
