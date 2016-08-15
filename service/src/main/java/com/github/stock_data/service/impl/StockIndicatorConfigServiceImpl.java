/*
 * Copyright [rapid-framework.com]
 * Web Site: http://www.rapid-framework.com
 * Since 2005 - 2016
 */

package com.github.stock_data.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.github.stock_data.service.StockIndicatorConfigService;

import com.github.rapid.common.util.holder.BeanValidatorHolder;
import com.github.rapid.common.util.page.Page;

import com.github.stock_data.model.*;
import com.github.stock_data.dao.*;
import com.github.stock_data.query.*;
import java.util.Date;

/**
 * [StockIndicatorConfig] 的Service接口实现
 * 
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */
@Service("stockIndicatorConfigService")
@Transactional
public class StockIndicatorConfigServiceImpl implements StockIndicatorConfigService {

	protected static final Logger logger = LoggerFactory.getLogger(StockIndicatorConfigServiceImpl.class);
	
	/*
	* 请删除无用的方法，本代码生成器的理念是: 1. 一次生成，后期手工修改代码 2. 删除代码比手写重复代码快捷，所以请删除无用代码
	*/
	
	private StockIndicatorConfigDao stockIndicatorConfigDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setStockIndicatorConfigDao(StockIndicatorConfigDao dao) {
		this.stockIndicatorConfigDao = dao;
	}
	
	/** 
	 * 创建StockIndicatorConfig
	 **/
	public StockIndicatorConfig create(StockIndicatorConfig stockIndicatorConfig) {
	    Assert.notNull(stockIndicatorConfig,"'stockIndicatorConfig' must be not null");
	    initDefaultValuesForCreate(stockIndicatorConfig);
	    new StockIndicatorConfigChecker().checkCreateStockIndicatorConfig(stockIndicatorConfig);
	    stockIndicatorConfigDao.insert(stockIndicatorConfig);
	    return stockIndicatorConfig;
	}
	
	/** 
	 * 更新StockIndicatorConfig
	 **/	
    public StockIndicatorConfig update(StockIndicatorConfig stockIndicatorConfig) {
        Assert.notNull(stockIndicatorConfig,"'stockIndicatorConfig' must be not null");
        new StockIndicatorConfigChecker().checkUpdateStockIndicatorConfig(stockIndicatorConfig);
        stockIndicatorConfigDao.update(stockIndicatorConfig);
        return stockIndicatorConfig;
    }	
    
    /**
     *  join取回StockIndicatorConfig的关联信息,如一对多，多对一等的关联信息
     */
    public StockIndicatorConfig join(StockIndicatorConfig stockIndicatorConfig) {
    	return stockIndicatorConfig;
    }
    
	/** 
	 * 删除StockIndicatorConfig
	 **/
    public void removeById(String stockId, String indicatorId) {
        stockIndicatorConfigDao.deleteById(stockId,indicatorId);
    }
    
	/** 
	 * 根据ID得到StockIndicatorConfig
	 **/    
    public StockIndicatorConfig getById(String stockId, String indicatorId) {
        return stockIndicatorConfigDao.getById(stockId,indicatorId);
    }
    
	/** 
	 * 分页查询: StockIndicatorConfig
	 **/      
	@Transactional(readOnly=true)
	public Page<StockIndicatorConfig> findPage(StockIndicatorConfigQuery query) {
	    Assert.notNull(query,"'query' must be not null");
		return stockIndicatorConfigDao.findPage(query);
	}
	
    
	/**
	 * 创建对象时初始化相关默认值 
	 **/
    public void initDefaultValuesForCreate(StockIndicatorConfig stockIndicatorConfig) {
    }
    
    /**
     * StockIndicatorConfig的属性检查类,根据自己需要编写自定义检查
     **/
    public class StockIndicatorConfigChecker {
        /**可以在此检查只有更新才需要的特殊检查 */
        public void checkUpdateStockIndicatorConfig(StockIndicatorConfig stockIndicatorConfig) {
            checkStockIndicatorConfig(stockIndicatorConfig);
        }
    
        /**可以在此检查只有创建才需要的特殊检查 */
        public void checkCreateStockIndicatorConfig(StockIndicatorConfig stockIndicatorConfig) {
            checkStockIndicatorConfig(stockIndicatorConfig);
        }
        
        /** 检查到有错误请直接抛异常，不要使用 return errorCode的方式 */
        public void checkStockIndicatorConfig(StockIndicatorConfig stockIndicatorConfig) {
        	// Bean Validator检查,属性检查失败将抛异常
        	BeanValidatorHolder.validateWithException(stockIndicatorConfig);
            
        	//复杂的属性的检查一般需要分开写几个方法，如 checkProperty1(v),checkProperty2(v)
        }
    }
}
