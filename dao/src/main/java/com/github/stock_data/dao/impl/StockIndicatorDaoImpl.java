/*
 * Copyright [rapid-framework.com]
 * Web Site: http://www.rapid-framework.com
 * Since 2005 - 2016
 */

package com.github.stock_data.dao.impl;

import com.github.stock_data.model.*;
import com.github.stock_data.query.*;

import com.github.stock_data.dao.StockIndicatorDao;



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
 * tableName: stock_indicator
 * [StockIndicator] 的Dao操作 
 *  
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
*/
public class StockIndicatorDaoImpl extends BaseSpringJdbcDao implements StockIndicatorDao{

	protected static final Logger logger = LoggerFactory.getLogger(StockIndicatorDaoImpl.class);
	
	/*
	* 请删除无用的方法，本代码生成器的理念是: 1. 一次生成，后期手工修改代码 2. 删除代码比手写重复代码快捷，所以请删除无用代码
	*/
	
	private RowMapper<StockIndicator> entityRowMapper = new BeanPropertyRowMapper<StockIndicator>(getEntityClass());
	
	static final private String COLUMNS = "stock_id,indicator_id,tdate,tdate_type,val,ext,update_time";
	static final private String SELECT_FROM = "select " + COLUMNS + " from stock_indicator";
	
	@Override
	public Class<StockIndicator> getEntityClass() {
		return StockIndicator.class;
	}
	
	@Override
	public String getIdentifierPropertyName() {
		return "stockId";
	}
	
	public RowMapper<StockIndicator> getEntityRowMapper() {
		return entityRowMapper;
	}
	
	public void insert(StockIndicator entity) {
		String sql = "insert into stock_indicator " 
			 + " (stock_id,indicator_id,tdate,tdate_type,val,ext,update_time) " 
			 + " values "
			 + " (:stockId,:indicatorId,:tdate,:tdateType,:val,:ext,:updateTime)";
//		insertWithGeneratedKey(entity,sql); //for sqlserver:identity and mysql:auto_increment
		
		//其它主键生成策略
		//insertWithOracleSequence(entity,"sequenceName",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		insertWithAssigned(entity,sql); //手工分配
	}
	
	public int update(StockIndicator entity) {
		String sql = "update stock_indicator set "
					+ " val=:val,ext=:ext,update_time=:updateTime"
					+ " where  stock_id = :stockId and indicator_id = :indicatorId and tdate = :tdate and tdate_type = :tdateType ";
		return getNamedParameterJdbcTemplate().update(sql, new BeanPropertySqlParameterSource(entity));
	}
	
	public int deleteById(String stockId, String indicatorId, Date tdate, String tdateType) {
		String sql = "delete from stock_indicator where  stock_id = ? and indicator_id = ? and tdate = ? and tdate_type = ? ";
		return  getJdbcTemplate().update(sql,  stockId,indicatorId,tdate,tdateType);
	}

	public StockIndicator getById(String stockId, String indicatorId, Date tdate, String tdateType) {
		String sql = SELECT_FROM + " where  stock_id = ? and indicator_id = ? and tdate = ? and tdate_type = ? ";
		return (StockIndicator)DataAccessUtils.singleResult(getJdbcTemplate().query(sql, getEntityRowMapper(),stockId,indicatorId,tdate,tdateType));
	}
	

	public Page<StockIndicator> findPage(StockIndicatorQuery query) {
		
		StringBuilder sql = new StringBuilder("select "+ COLUMNS + " from stock_indicator where 1=1 ");
		if(ObjectUtil.isNotEmpty(query.getStockId())) {
            sql.append(" and stock_id = :stockId ");
        }
		if(ObjectUtil.isNotEmpty(query.getIndicatorId())) {
            sql.append(" and indicator_id = :indicatorId ");
        }
		if(ObjectUtil.isNotEmpty(query.getTdateBegin())) {
		    sql.append(" and tdate >= :tdateBegin ");
		}
		if(ObjectUtil.isNotEmpty(query.getTdateEnd())) {
            sql.append(" and tdate <= :tdateEnd ");
        }
		if(ObjectUtil.isNotEmpty(query.getTdateType())) {
            sql.append(" and tdate_type = :tdateType ");
        }
		if(ObjectUtil.isNotEmpty(query.getVal())) {
            sql.append(" and val = :val ");
        }
		if(ObjectUtil.isNotEmpty(query.getExt())) {
            sql.append(" and ext = :ext ");
        }
		
        //sql.append(" order by :sortColumns ");
		
		return pageQuery(sql.toString(),query,getEntityRowMapper());				
	}
}
