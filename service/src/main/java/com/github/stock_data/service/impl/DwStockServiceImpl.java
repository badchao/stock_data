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

import com.github.stock_data.service.DwStockService;

import com.github.rapid.common.util.holder.BeanValidatorHolder;
import com.github.rapid.common.util.page.Page;

import com.github.stock_data.model.*;
import com.github.stock_data.dao.*;
import com.github.stock_data.query.*;
import java.util.Date;

/**
 * [DwStock] 的Service接口实现
 * 
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */
@Service("dwStockService")
@Transactional
public class DwStockServiceImpl implements DwStockService {

	protected static final Logger logger = LoggerFactory.getLogger(DwStockServiceImpl.class);
	
	/*
	* 请删除无用的方法，本代码生成器的理念是: 1. 一次生成，后期手工修改代码 2. 删除代码比手写重复代码快捷，所以请删除无用代码
	*/
	
	private DwStockDao dwStockDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setDwStockDao(DwStockDao dao) {
		this.dwStockDao = dao;
	}
	
	/** 
	 * 创建DwStock
	 **/
	public DwStock create(DwStock dwStock) {
	    Assert.notNull(dwStock,"'dwStock' must be not null");
	    initDefaultValuesForCreate(dwStock);
	    new DwStockChecker().checkCreateDwStock(dwStock);
	    dwStockDao.insert(dwStock);
	    return dwStock;
	}
	
	/** 
	 * 更新DwStock
	 **/	
    public DwStock update(DwStock dwStock) {
        Assert.notNull(dwStock,"'dwStock' must be not null");
        new DwStockChecker().checkUpdateDwStock(dwStock);
        dwStockDao.update(dwStock);
        return dwStock;
    }	
    
    /**
     *  join取回DwStock的关联信息,如一对多，多对一等的关联信息
     */
    public DwStock join(DwStock dwStock) {
    	return dwStock;
    }
    
	/** 
	 * 删除DwStock
	 **/
    public void removeById(String stockId, Date tdate, String tdateType) {
        dwStockDao.deleteById(stockId,tdate,tdateType);
    }
    
	/** 
	 * 根据ID得到DwStock
	 **/    
    public DwStock getById(String stockId, Date tdate, String tdateType) {
        return dwStockDao.getById(stockId,tdate,tdateType);
    }
    
	/** 
	 * 分页查询: DwStock
	 **/      
	@Transactional(readOnly=true)
	public Page<DwStock> findPage(DwStockQuery query) {
	    Assert.notNull(query,"'query' must be not null");
		return dwStockDao.findPage(query);
	}
	
    
	/**
	 * 创建对象时初始化相关默认值 
	 **/
    public void initDefaultValuesForCreate(DwStock dwStock) {
    }
    
    /**
     * DwStock的属性检查类,根据自己需要编写自定义检查
     **/
    public class DwStockChecker {
        /**可以在此检查只有更新才需要的特殊检查 */
        public void checkUpdateDwStock(DwStock dwStock) {
            checkDwStock(dwStock);
        }
    
        /**可以在此检查只有创建才需要的特殊检查 */
        public void checkCreateDwStock(DwStock dwStock) {
            checkDwStock(dwStock);
        }
        
        /** 检查到有错误请直接抛异常，不要使用 return errorCode的方式 */
        public void checkDwStock(DwStock dwStock) {
        	// Bean Validator检查,属性检查失败将抛异常
        	BeanValidatorHolder.validateWithException(dwStock);
            
        	//复杂的属性的检查一般需要分开写几个方法，如 checkProperty1(v),checkProperty2(v)
        }
    }
}
