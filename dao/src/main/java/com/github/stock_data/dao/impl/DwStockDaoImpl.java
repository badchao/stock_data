/*
 * Copyright [rapid-framework.com]
 * Web Site: http://www.rapid-framework.com
 * Since 2005 - 2016
 */

package com.github.stock_data.dao.impl;

import com.github.stock_data.model.*;
import com.github.stock_data.query.*;

import com.github.stock_data.dao.DwStockDao;



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
 * tableName: dw_stock
 * [DwStock] 的Dao操作 
 *  
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
*/
public class DwStockDaoImpl extends BaseSpringJdbcDao implements DwStockDao{

	protected static final Logger logger = LoggerFactory.getLogger(DwStockDaoImpl.class);
	
	/*
	* 请删除无用的方法，本代码生成器的理念是: 1. 一次生成，后期手工修改代码 2. 删除代码比手写重复代码快捷，所以请删除无用代码
	*/
	
	private RowMapper<DwStock> entityRowMapper = new BeanPropertyRowMapper<DwStock>(getEntityClass());
	
	static final private String COLUMNS = "stock_id,tdate,tdate_type,pe,pb,reverce,company_value";
	static final private String SELECT_FROM = "select " + COLUMNS + " from dw_stock";
	
	@Override
	public Class<DwStock> getEntityClass() {
		return DwStock.class;
	}
	
	@Override
	public String getIdentifierPropertyName() {
		return "stockId";
	}
	
	public RowMapper<DwStock> getEntityRowMapper() {
		return entityRowMapper;
	}
	
	public void insert(DwStock entity) {
		String sql = "insert into dw_stock " 
			 + " (stock_id,tdate,tdate_type,pe,pb,reverce,company_value) " 
			 + " values "
			 + " (:stockId,:tdate,:tdateType,:pe,:pb,:reverce,:companyValue)";
//		insertWithGeneratedKey(entity,sql); //for sqlserver:identity and mysql:auto_increment
		
		//其它主键生成策略
		//insertWithOracleSequence(entity,"sequenceName",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		insertWithAssigned(entity,sql); //手工分配
	}
	
	public int update(DwStock entity) {
		String sql = "update dw_stock set "
					+ " pe=:pe,pb=:pb,reverce=:reverce,company_value=:companyValue "
					+ " where  stock_id = :stockId and tdate = :tdate and tdate_type = :tdateType ";
		return getNamedParameterJdbcTemplate().update(sql, new BeanPropertySqlParameterSource(entity));
	}
	
	public int deleteById(String stockId, Date tdate, String tdateType) {
		String sql = "delete from dw_stock where  stock_id = ? and tdate = ? and tdate_type = ? ";
		return  getJdbcTemplate().update(sql,  stockId,tdate,tdateType);
	}

	public DwStock getById(String stockId, Date tdate, String tdateType) {
		String sql = SELECT_FROM + " where  stock_id = ? and tdate = ? and tdate_type = ? ";
		return (DwStock)DataAccessUtils.singleResult(getJdbcTemplate().query(sql, getEntityRowMapper(),stockId,tdate,tdateType));
	}
	

	public Page<DwStock> findPage(DwStockQuery query) {
		
		StringBuilder sql = new StringBuilder("select "+ COLUMNS + " from dw_stock where 1=1 ");
		if(ObjectUtil.isNotEmpty(query.getStockId())) {
            sql.append(" and stock_id = :stockId ");
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
		if(ObjectUtil.isNotEmpty(query.getPe())) {
            sql.append(" and pe = :pe ");
        }
		if(ObjectUtil.isNotEmpty(query.getPb())) {
            sql.append(" and pb = :pb ");
        }
		if(ObjectUtil.isNotEmpty(query.getReverce())) {
            sql.append(" and reverce = :reverce ");
        }
		if(ObjectUtil.isNotEmpty(query.getCompanyValue())) {
            sql.append(" and company_value = :companyValue ");
        }
		
        //sql.append(" order by :sortColumns ");
		
		return pageQuery(sql.toString(),query,getEntityRowMapper());				
	}
}
