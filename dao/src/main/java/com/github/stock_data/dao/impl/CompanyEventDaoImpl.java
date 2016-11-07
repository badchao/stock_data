/*
 * Copyright [rapid-framework.com]
 * Web Site: http://www.rapid-framework.com
 * Since 2005 - 2016
 */

package com.github.stock_data.dao.impl;

import com.github.stock_data.model.*;
import com.github.stock_data.query.*;

import com.github.stock_data.dao.CompanyEventDao;



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
 * tableName: company_event
 * [CompanyEvent] 的Dao操作 
 *  
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
*/
public class CompanyEventDaoImpl extends BaseSpringJdbcDao implements CompanyEventDao{

	protected static final Logger logger = LoggerFactory.getLogger(CompanyEventDaoImpl.class);
	
	/*
	* 请删除无用的方法，本代码生成器的理念是: 1. 一次生成，后期手工修改代码 2. 删除代码比手写重复代码快捷，所以请删除无用代码
	*/
	
	private RowMapper<CompanyEvent> entityRowMapper = new BeanPropertyRowMapper<CompanyEvent>(getEntityClass());
	
	static final private String COLUMNS = "id,tdate,company_name,stock_event,relate_company,remarks,attention_date,relate_stock";
	static final private String SELECT_FROM = "select " + COLUMNS + " from company_event";
	
	@Override
	public Class<CompanyEvent> getEntityClass() {
		return CompanyEvent.class;
	}
	
	@Override
	public String getIdentifierPropertyName() {
		return "id";
	}
	
	public RowMapper<CompanyEvent> getEntityRowMapper() {
		return entityRowMapper;
	}
	
	public void insert(CompanyEvent entity) {
		String sql = "insert into company_event " 
			 + " (id,tdate,company_name,stock_event,relate_company,remarks,attention_date,relate_stock) " 
			 + " values "
			 + " (:id,:tdate,:companyName,:stockEvent,:relateCompany,:remarks,:attentionDate,:relateStock)";
		insertWithGeneratedKey(entity,sql); //for sqlserver:identity and mysql:auto_increment
		
		//其它主键生成策略
		//insertWithOracleSequence(entity,"sequenceName",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		//insertWithAssigned(entity,sql); //手工分配
	}
	
	public int update(CompanyEvent entity) {
		String sql = "update company_event set "
					+ " tdate=:tdate,company_name=:companyName,stock_event=:stockEvent,relate_company=:relateCompany,remarks=:remarks,attention_date=:attentionDate,relate_stock=:relateStock "
					+ " where  id = :id ";
		return getNamedParameterJdbcTemplate().update(sql, new BeanPropertySqlParameterSource(entity));
	}
	
	public int deleteById(long id) {
		String sql = "delete from company_event where  id = ? ";
		return  getJdbcTemplate().update(sql,  id);
	}

	public CompanyEvent getById(long id) {
		String sql = SELECT_FROM + " where  id = ? ";
		return (CompanyEvent)DataAccessUtils.singleResult(getJdbcTemplate().query(sql, getEntityRowMapper(),id));
	}
	

	public Page<CompanyEvent> findPage(CompanyEventQuery query) {
		
		StringBuilder sql = new StringBuilder("select "+ COLUMNS + " from company_event where 1=1 ");
		if(ObjectUtil.isNotEmpty(query.getId())) {
            sql.append(" and id = :id ");
        }
		if(ObjectUtil.isNotEmpty(query.getTdateBegin())) {
		    sql.append(" and tdate >= :tdateBegin ");
		}
		if(ObjectUtil.isNotEmpty(query.getTdateEnd())) {
            sql.append(" and tdate <= :tdateEnd ");
        }
		if(ObjectUtil.isNotEmpty(query.getCompanyName())) {
            sql.append(" and company_name = :companyName ");
        }
		if(ObjectUtil.isNotEmpty(query.getStockEvent())) {
            sql.append(" and stock_event = :stockEvent ");
        }
		if(ObjectUtil.isNotEmpty(query.getRelateCompany())) {
            sql.append(" and relate_company = :relateCompany ");
        }
		if(ObjectUtil.isNotEmpty(query.getRemarks())) {
            sql.append(" and remarks = :remarks ");
        }
		if(ObjectUtil.isNotEmpty(query.getAttentionDateBegin())) {
		    sql.append(" and attention_date >= :attentionDateBegin ");
		}
		if(ObjectUtil.isNotEmpty(query.getAttentionDateEnd())) {
            sql.append(" and attention_date <= :attentionDateEnd ");
        }
		if(ObjectUtil.isNotEmpty(query.getRelateStock())) {
            sql.append(" and relate_stock = :relateStock ");
        }
		
        //sql.append(" order by :sortColumns ");
		
		return pageQuery(sql.toString(),query,getEntityRowMapper());				
	}
}
