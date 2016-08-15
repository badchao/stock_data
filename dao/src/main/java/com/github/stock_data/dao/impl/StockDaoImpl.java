/*
 * Copyright [rapid-framework.com]
 * Web Site: http://www.rapid-framework.com
 * Since 2005 - 2016
 */

package com.github.stock_data.dao.impl;

import com.github.stock_data.model.*;
import com.github.stock_data.query.*;

import com.github.stock_data.dao.StockDao;



import java.io.Serializable;
import java.util.List;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;

import com.github.rapid.common.util.page.Page;
import com.github.rapid.common.util.ObjectUtil;
import com.github.rapid.common.jdbc.dao.support.BaseSpringJdbcDao;

/**
 * tableName: stock
 * [Stock] 的Dao操作 
 *  
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
*/
public class StockDaoImpl extends BaseSpringJdbcDao implements StockDao{

	protected static final Logger logger = LoggerFactory.getLogger(StockDaoImpl.class);
	
	/*
	* 请删除无用的方法，本代码生成器的理念是: 1. 一次生成，后期手工修改代码 2. 删除代码比手写重复代码快捷，所以请删除无用代码
	*/
	
	private RowMapper<Stock> entityRowMapper = new BeanPropertyRowMapper<Stock>(getEntityClass());
	
	static final private String COLUMNS = "stock_id,stock_code,stock_name,market,zone,remarks";
	static final private String SELECT_FROM = "select " + COLUMNS + " from stock";
	
	@Override
	public Class<Stock> getEntityClass() {
		return Stock.class;
	}
	
	@Override
	public String getIdentifierPropertyName() {
		return "stockId";
	}
	
	public RowMapper<Stock> getEntityRowMapper() {
		return entityRowMapper;
	}
	
	public void insert(Stock entity) {
		String sql = "insert into stock " 
			 + " (stock_id,stock_code,stock_name,market,zone,remarks) " 
			 + " values "
			 + " (:stockId,:stockCode,:stockName,:market,:zone,:remarks)";
//		insertWithGeneratedKey(entity,sql); //for sqlserver:identity and mysql:auto_increment
		
		//其它主键生成策略
		//insertWithOracleSequence(entity,"sequenceName",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		insertWithAssigned(entity,sql); //手工分配
	}
	
	public int update(Stock entity) {
		String sql = "update stock set "
					+ " stock_code=:stockCode,stock_name=:stockName,market=:market,zone=:zone,remarks=:remarks "
					+ " where  stock_id = :stockId ";
		return getNamedParameterJdbcTemplate().update(sql, new BeanPropertySqlParameterSource(entity));
	}
	
	public int deleteById(String stockId) {
		String sql = "delete from stock where  stock_id = ? ";
		return  getJdbcTemplate().update(sql,  stockId);
	}

	public Stock getById(String stockId) {
		String sql = SELECT_FROM + " where  stock_id = ? ";
		return (Stock)DataAccessUtils.singleResult(getJdbcTemplate().query(sql, getEntityRowMapper(),stockId));
	}
	

	public Page<Stock> findPage(StockQuery query) {
		
		StringBuilder sql = new StringBuilder("select "+ COLUMNS + " from stock where 1=1 ");
		if(ObjectUtil.isNotEmpty(query.getStockId())) {
            sql.append(" and stock_id = :stockId ");
        }
		if(ObjectUtil.isNotEmpty(query.getStockCode())) {
            sql.append(" and stock_code = :stockCode ");
        }
		if(ObjectUtil.isNotEmpty(query.getStockName())) {
            sql.append(" and stock_name = :stockName ");
        }
		if(ObjectUtil.isNotEmpty(query.getMarket())) {
            sql.append(" and market = :market ");
        }
		if(ObjectUtil.isNotEmpty(query.getZone())) {
            sql.append(" and zone = :zone ");
        }
		if(ObjectUtil.isNotEmpty(query.getRemarks())) {
            sql.append(" and remarks = :remarks ");
        }
		
        //sql.append(" order by :sortColumns ");
		
		return pageQuery(sql.toString(),query,getEntityRowMapper());				
	}
}
