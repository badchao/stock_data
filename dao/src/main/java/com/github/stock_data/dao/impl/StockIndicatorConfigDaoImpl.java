/*
 * Copyright [rapid-framework.com]
 * Web Site: http://www.rapid-framework.com
 * Since 2005 - 2016
 */

package com.github.stock_data.dao.impl;

import com.github.stock_data.model.*;
import com.github.stock_data.query.*;

import com.github.stock_data.dao.StockIndicatorConfigDao;



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
 * tableName: stock_indicator_config
 * [StockIndicatorConfig] 的Dao操作 
 *  
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
*/
public class StockIndicatorConfigDaoImpl extends BaseSpringJdbcDao implements StockIndicatorConfigDao{

	protected static final Logger logger = LoggerFactory.getLogger(StockIndicatorConfigDaoImpl.class);
	
	/*
	* 请删除无用的方法，本代码生成器的理念是: 1. 一次生成，后期手工修改代码 2. 删除代码比手写重复代码快捷，所以请删除无用代码
	*/
	
	private RowMapper<StockIndicatorConfig> entityRowMapper = new BeanPropertyRowMapper<StockIndicatorConfig>(getEntityClass());
	
	static final private String COLUMNS = "stock_id,indicator_id,indicator_name,crawl_url,crawl_script,crawl_cron,calc_expr,remarks,crawl_status,crawl_log,last_crawl_time";
	static final private String SELECT_FROM = "select " + COLUMNS + " from stock_indicator_config";
	
	@Override
	public Class<StockIndicatorConfig> getEntityClass() {
		return StockIndicatorConfig.class;
	}
	
	@Override
	public String getIdentifierPropertyName() {
		return "stockId";
	}
	
	public RowMapper<StockIndicatorConfig> getEntityRowMapper() {
		return entityRowMapper;
	}
	
	public void insert(StockIndicatorConfig entity) {
		String sql = "insert into stock_indicator_config " 
			 + " (stock_id,indicator_id,indicator_name,crawl_url,crawl_script,crawl_cron,calc_expr,remarks,crawl_status,crawl_log,last_crawl_time) " 
			 + " values "
			 + " (:stockId,:indicatorId,:indicatorName,:crawlUrl,:crawlScript,:crawlCron,:calcExpr,:remarks,:crawlStatus,:crawlLog,:lastCrawlTime)";
//		insertWithGeneratedKey(entity,sql); //for sqlserver:identity and mysql:auto_increment
		
		//其它主键生成策略
		//insertWithOracleSequence(entity,"sequenceName",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		insertWithAssigned(entity,sql); //手工分配
	}
	
	public int update(StockIndicatorConfig entity) {
		String sql = "update stock_indicator_config set "
					+ " indicator_name=:indicatorName,crawl_url=:crawlUrl,crawl_script=:crawlScript,crawl_cron=:crawlCron,calc_expr=:calcExpr,remarks=:remarks,crawl_status=:crawlStatus,crawl_log=:crawlLog,last_crawl_time=:lastCrawlTime "
					+ " where  stock_id = :stockId and indicator_id = :indicatorId ";
		return getNamedParameterJdbcTemplate().update(sql, new BeanPropertySqlParameterSource(entity));
	}
	
	public int deleteById(String stockId, String indicatorId) {
		String sql = "delete from stock_indicator_config where  stock_id = ? and indicator_id = ? ";
		return  getJdbcTemplate().update(sql,  stockId,indicatorId);
	}

	public StockIndicatorConfig getById(String stockId, String indicatorId) {
		String sql = SELECT_FROM + " where  stock_id = ? and indicator_id = ? ";
		return (StockIndicatorConfig)DataAccessUtils.singleResult(getJdbcTemplate().query(sql, getEntityRowMapper(),stockId,indicatorId));
	}
	

	public Page<StockIndicatorConfig> findPage(StockIndicatorConfigQuery query) {
		
		StringBuilder sql = new StringBuilder("select "+ COLUMNS + " from stock_indicator_config where 1=1 ");
		if(ObjectUtil.isNotEmpty(query.getStockId())) {
            sql.append(" and stock_id = :stockId ");
        }
		if(ObjectUtil.isNotEmpty(query.getIndicatorId())) {
            sql.append(" and indicator_id = :indicatorId ");
        }
		if(ObjectUtil.isNotEmpty(query.getIndicatorName())) {
            sql.append(" and indicator_name = :indicatorName ");
        }
		if(ObjectUtil.isNotEmpty(query.getCrawlUrl())) {
            sql.append(" and crawl_url = :crawlUrl ");
        }
		if(ObjectUtil.isNotEmpty(query.getCrawlScript())) {
            sql.append(" and crawl_script = :crawlScript ");
        }
		if(ObjectUtil.isNotEmpty(query.getCrawlCron())) {
            sql.append(" and crawl_cron = :crawlCron ");
        }
		if(ObjectUtil.isNotEmpty(query.getCalcExpr())) {
            sql.append(" and calc_expr = :calcExpr ");
        }
		if(ObjectUtil.isNotEmpty(query.getRemarks())) {
            sql.append(" and remarks = :remarks ");
        }
		
        //sql.append(" order by :sortColumns ");
		
		return pageQuery(sql.toString(),query,getEntityRowMapper());				
	}
}
