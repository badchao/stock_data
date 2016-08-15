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

import com.github.stock_data.service.StockService;

import com.github.rapid.common.util.holder.BeanValidatorHolder;
import com.github.rapid.common.util.page.Page;

import com.github.stock_data.model.*;
import com.github.stock_data.dao.*;
import com.github.stock_data.query.*;
import java.util.Date;

/**
 * [Stock] 的Service接口实现
 * 
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */
@Service("stockService")
@Transactional
public class StockServiceImpl implements StockService {

	protected static final Logger logger = LoggerFactory.getLogger(StockServiceImpl.class);
	
	/*
	* 请删除无用的方法，本代码生成器的理念是: 1. 一次生成，后期手工修改代码 2. 删除代码比手写重复代码快捷，所以请删除无用代码
	*/
	
	private StockDao stockDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setStockDao(StockDao dao) {
		this.stockDao = dao;
	}
	
	/** 
	 * 创建Stock
	 **/
	public Stock create(Stock stock) {
	    Assert.notNull(stock,"'stock' must be not null");
	    initDefaultValuesForCreate(stock);
	    new StockChecker().checkCreateStock(stock);
	    stockDao.insert(stock);
	    return stock;
	}
	
	/** 
	 * 更新Stock
	 **/	
    public Stock update(Stock stock) {
        Assert.notNull(stock,"'stock' must be not null");
        new StockChecker().checkUpdateStock(stock);
        stockDao.update(stock);
        return stock;
    }	
    
    /**
     *  join取回Stock的关联信息,如一对多，多对一等的关联信息
     */
    public Stock join(Stock stock) {
    	return stock;
    }
    
	/** 
	 * 删除Stock
	 **/
    public void removeById(String stockId) {
        stockDao.deleteById(stockId);
    }
    
	/** 
	 * 根据ID得到Stock
	 **/    
    public Stock getById(String stockId) {
        return stockDao.getById(stockId);
    }
    
	/** 
	 * 分页查询: Stock
	 **/      
	@Transactional(readOnly=true)
	public Page<Stock> findPage(StockQuery query) {
	    Assert.notNull(query,"'query' must be not null");
		return stockDao.findPage(query);
	}
	
    
	/**
	 * 创建对象时初始化相关默认值 
	 **/
    public void initDefaultValuesForCreate(Stock stock) {
    }
    
    /**
     * Stock的属性检查类,根据自己需要编写自定义检查
     **/
    public class StockChecker {
        /**可以在此检查只有更新才需要的特殊检查 */
        public void checkUpdateStock(Stock stock) {
            checkStock(stock);
        }
    
        /**可以在此检查只有创建才需要的特殊检查 */
        public void checkCreateStock(Stock stock) {
            checkStock(stock);
        }
        
        /** 检查到有错误请直接抛异常，不要使用 return errorCode的方式 */
        public void checkStock(Stock stock) {
        	// Bean Validator检查,属性检查失败将抛异常
        	BeanValidatorHolder.validateWithException(stock);
            
        	//复杂的属性的检查一般需要分开写几个方法，如 checkProperty1(v),checkProperty2(v)
        }
    }
}
