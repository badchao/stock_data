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

import com.github.stock_data.service.StockIndicatorService;

import com.github.rapid.common.util.holder.BeanValidatorHolder;
import com.github.rapid.common.util.page.Page;

import com.github.stock_data.model.*;
import com.github.stock_data.dao.*;
import com.github.stock_data.query.*;
import java.util.Date;

/**
 * [StockIndicator] 的Service接口实现
 * 
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */
@Service("stockIndicatorService")
@Transactional
public class StockIndicatorServiceImpl implements StockIndicatorService {

	protected static final Logger logger = LoggerFactory.getLogger(StockIndicatorServiceImpl.class);
	
	/*
	* 请删除无用的方法，本代码生成器的理念是: 1. 一次生成，后期手工修改代码 2. 删除代码比手写重复代码快捷，所以请删除无用代码
	*/
	
	private StockIndicatorDao stockIndicatorDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setStockIndicatorDao(StockIndicatorDao dao) {
		this.stockIndicatorDao = dao;
	}
	
	/** 
	 * 创建StockIndicator
	 **/
	public StockIndicator create(StockIndicator stockIndicator) {
	    Assert.notNull(stockIndicator,"'stockIndicator' must be not null");
	    initDefaultValuesForCreate(stockIndicator);
	    new StockIndicatorChecker().checkCreateStockIndicator(stockIndicator);
	    stockIndicatorDao.insert(stockIndicator);
	    return stockIndicator;
	}
	
	/** 
	 * 更新StockIndicator
	 **/	
    public StockIndicator update(StockIndicator stockIndicator) {
        Assert.notNull(stockIndicator,"'stockIndicator' must be not null");
        new StockIndicatorChecker().checkUpdateStockIndicator(stockIndicator);
        stockIndicatorDao.update(stockIndicator);
        return stockIndicator;
    }	
    
    /**
     *  join取回StockIndicator的关联信息,如一对多，多对一等的关联信息
     */
    public StockIndicator join(StockIndicator stockIndicator) {
    	return stockIndicator;
    }
    
	/** 
	 * 删除StockIndicator
	 **/
    public void removeById(String stockId, String indicatorId, Date tdate, String tdateType) {
        stockIndicatorDao.deleteById(stockId,indicatorId,tdate,tdateType);
    }
    
	/** 
	 * 根据ID得到StockIndicator
	 **/    
    public StockIndicator getById(String stockId, String indicatorId, Date tdate, String tdateType) {
        return stockIndicatorDao.getById(stockId,indicatorId,tdate,tdateType);
    }
    
	/** 
	 * 分页查询: StockIndicator
	 **/      
	@Transactional(readOnly=true)
	public Page<StockIndicator> findPage(StockIndicatorQuery query) {
	    Assert.notNull(query,"'query' must be not null");
		return stockIndicatorDao.findPage(query);
	}
	
    
	/**
	 * 创建对象时初始化相关默认值 
	 **/
    public void initDefaultValuesForCreate(StockIndicator stockIndicator) {
    }
    
    /**
     * StockIndicator的属性检查类,根据自己需要编写自定义检查
     **/
    public class StockIndicatorChecker {
        /**可以在此检查只有更新才需要的特殊检查 */
        public void checkUpdateStockIndicator(StockIndicator stockIndicator) {
            checkStockIndicator(stockIndicator);
        }
    
        /**可以在此检查只有创建才需要的特殊检查 */
        public void checkCreateStockIndicator(StockIndicator stockIndicator) {
            checkStockIndicator(stockIndicator);
        }
        
        /** 检查到有错误请直接抛异常，不要使用 return errorCode的方式 */
        public void checkStockIndicator(StockIndicator stockIndicator) {
        	// Bean Validator检查,属性检查失败将抛异常
        	BeanValidatorHolder.validateWithException(stockIndicator);
            
        	//复杂的属性的检查一般需要分开写几个方法，如 checkProperty1(v),checkProperty2(v)
        }
    }
}
