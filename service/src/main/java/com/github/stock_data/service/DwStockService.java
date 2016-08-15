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
 * [DwStock] 的Service接口
 * 
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */
public interface DwStockService {

	/** 
	 * 创建DwStock
	 **/
	public DwStock create(DwStock dwStock);
	
	/** 
	 * 更新DwStock
	 **/	
    public DwStock update(DwStock dwStock);
    
    /**
     *  join取回DwStock的关联信息,如一对多，多对一等的关联信息
     */
    public DwStock join(DwStock dwStock);
    
	/** 
	 * 删除DwStock
	 **/
    public void removeById(String stockId, Date tdate, String tdateType);
    
	/** 
	 * 根据ID得到DwStock
	 **/    
    public DwStock getById(String stockId, Date tdate, String tdateType);
    
	/** 
	 * 分页查询: DwStock
	 **/      
	public Page<DwStock> findPage(DwStockQuery query);
	
    
}
