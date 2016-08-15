/*
 * Copyright [rapid-framework.com]
 * Web Site: http://www.rapid-framework.com
 * Since 2005 - 2016
 */

package com.github.stock_data.dao.impl;

import com.github.stock_data.model.*;
import com.github.stock_data.query.*;

import com.github.stock_data.dao.UserDao;



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
 * tableName: user
 * [User] 的Dao操作 
 *  
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
*/
public class UserDaoImpl extends BaseSpringJdbcDao implements UserDao{

	protected static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
	
	/*
	* 请删除无用的方法，本代码生成器的理念是: 1. 一次生成，后期手工修改代码 2. 删除代码比手写重复代码快捷，所以请删除无用代码
	*/
	
	private RowMapper<User> entityRowMapper = new BeanPropertyRowMapper<User>(getEntityClass());
	
	static final private String COLUMNS = "account,password,name,mobile,email,remarks,enabled";
	static final private String SELECT_FROM = "select " + COLUMNS + " from user";
	
	@Override
	public Class<User> getEntityClass() {
		return User.class;
	}
	
	@Override
	public String getIdentifierPropertyName() {
		return "account";
	}
	
	public RowMapper<User> getEntityRowMapper() {
		return entityRowMapper;
	}
	
	public void insert(User entity) {
		String sql = "insert into user " 
			 + " (account,password,name,mobile,email,remarks,enabled) " 
			 + " values "
			 + " (:account,:password,:name,:mobile,:email,:remarks,:enabled)";
//		insertWithGeneratedKey(entity,sql); //for sqlserver:identity and mysql:auto_increment
		
		//其它主键生成策略
		//insertWithOracleSequence(entity,"sequenceName",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		insertWithAssigned(entity,sql); //手工分配
	}
	
	public int update(User entity) {
		String sql = "update user set "
					+ " name=:name,mobile=:mobile,email=:email,remarks=:remarks,enabled=:enabled "
					+ " where  account = :account ";
		return getNamedParameterJdbcTemplate().update(sql, new BeanPropertySqlParameterSource(entity));
	}
	
	public int updatePassword(User entity) {
		String sql = "update user set "
					+ " password=:password "
					+ " where account = :account ";
		return getNamedParameterJdbcTemplate().update(sql, new BeanPropertySqlParameterSource(entity));
	}
	
	public int deleteById(String account) {
		String sql = "delete from user where  account = ? ";
		return  getJdbcTemplate().update(sql,  account);
	}

	public User getById(String account) {
		String sql = SELECT_FROM + " where  account = ? ";
		return (User)DataAccessUtils.singleResult(getJdbcTemplate().query(sql, getEntityRowMapper(),account));
	}
	

	public Page<User> findPage(UserQuery query) {
		
		StringBuilder sql = new StringBuilder("select "+ COLUMNS + " from user where 1=1 ");
		if(ObjectUtil.isNotEmpty(query.getAccount())) {
            sql.append(" and account = :account ");
        }
		if(ObjectUtil.isNotEmpty(query.getPassword())) {
            sql.append(" and password = :password ");
        }
		if(ObjectUtil.isNotEmpty(query.getName())) {
            sql.append(" and name = :name ");
        }
		if(ObjectUtil.isNotEmpty(query.getMobile())) {
            sql.append(" and mobile = :mobile ");
        }
		if(ObjectUtil.isNotEmpty(query.getEmail())) {
            sql.append(" and email = :email ");
        }
		if(ObjectUtil.isNotEmpty(query.getRemarks())) {
            sql.append(" and remarks = :remarks ");
        }
		if(ObjectUtil.isNotEmpty(query.getEnabled())) {
            sql.append(" and enabled = :enabled ");
        }
		
        //sql.append(" order by :sortColumns ");
		
		return pageQuery(sql.toString(),query,getEntityRowMapper());				
	}
}
