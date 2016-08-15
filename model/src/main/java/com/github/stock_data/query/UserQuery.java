/*
 * Copyright [rapid-framework.com]
 * Web Site: http://www.rapid-framework.com
 * Since 2005 - 2016
 */

package com.github.stock_data.query;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;

import com.github.rapid.common.util.page.PageQuery;

/**
 * [User] 查询对象
 * 
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */
public class UserQuery extends PageQuery implements Serializable {
    private static final long serialVersionUID = 3148176768559230877L;
    

	/** account */
	private String account;
	/** password */
	private String password;
	/** name */
	private String name;
	/** mobile */
	private String mobile;
	/** email */
	private String email;
	/** remarks */
	private String remarks;
	/** enabled */
	private Integer enabled;

	public String getAccount() {
		return this.account;
	}
	
	public UserQuery setAccount(String account) {
		this.account = account;
		return this;
	}
	
	public String account() {
		return this.account;
	}

	public UserQuery account(String account) {
		this.account = account;
		return this;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public UserQuery setPassword(String password) {
		this.password = password;
		return this;
	}
	
	public String password() {
		return this.password;
	}

	public UserQuery password(String password) {
		this.password = password;
		return this;
	}
	
	public String getName() {
		return this.name;
	}
	
	public UserQuery setName(String name) {
		this.name = name;
		return this;
	}
	
	public String name() {
		return this.name;
	}

	public UserQuery name(String name) {
		this.name = name;
		return this;
	}
	
	public String getMobile() {
		return this.mobile;
	}
	
	public UserQuery setMobile(String mobile) {
		this.mobile = mobile;
		return this;
	}
	
	public String mobile() {
		return this.mobile;
	}

	public UserQuery mobile(String mobile) {
		this.mobile = mobile;
		return this;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public UserQuery setEmail(String email) {
		this.email = email;
		return this;
	}
	
	public String email() {
		return this.email;
	}

	public UserQuery email(String email) {
		this.email = email;
		return this;
	}
	
	public String getRemarks() {
		return this.remarks;
	}
	
	public UserQuery setRemarks(String remarks) {
		this.remarks = remarks;
		return this;
	}
	
	public String remarks() {
		return this.remarks;
	}

	public UserQuery remarks(String remarks) {
		this.remarks = remarks;
		return this;
	}
	
	public Integer getEnabled() {
		return this.enabled;
	}
	
	public UserQuery setEnabled(Integer enabled) {
		this.enabled = enabled;
		return this;
	}
	
	public Integer enabled() {
		return this.enabled;
	}

	public UserQuery enabled(Integer enabled) {
		this.enabled = enabled;
		return this;
	}
	

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
}

