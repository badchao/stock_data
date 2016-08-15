/*
 * Copyright [rapid-framework.com]
 * Web Site: http://www.rapid-framework.com
 * Since 2005 - 2016
 */

package com.github.stock_data.model;

import javax.validation.constraints.*;
import java.util.*;
import org.hibernate.validator.constraints.*;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;



/**
 * tableName: user [User] 
 * 
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */
public class User  implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//date formats
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * account       db_column: account 
     */ 	
	@Length(max=50)
	private String account;
	
    /**
     * password       db_column: password 
     */ 	
	@Length(max=50)
	private String password;
	
    /**
     * name       db_column: name 
     */ 	
	@Length(max=50)
	private String name;
	
    /**
     * mobile       db_column: mobile 
     */ 	
	@Length(max=50)
	private String mobile;
	
    /**
     * email       db_column: email 
     */ 	
	@Email @Length(max=50)
	private String email;
	
    /**
     * remarks       db_column: remarks 
     */ 	
	@Length(max=50)
	private String remarks;
	
    /**
     * enabled       db_column: enabled 
     */ 	
	@Max(127)
	private Integer enabled;
	
	//columns END

	public User(){
	}

	public User(
		String account
	){
		this.account = account;
	}

	public String getAccount() {
		return this.account;
	}
	
	public void setAccount(String account) {
		this.account = account;
	}
	
	public String account() {
		return this.account;
	}

	public User account(String account) {
		this.account = account;
		return this;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String password() {
		return this.password;
	}

	public User password(String password) {
		this.password = password;
		return this;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String name() {
		return this.name;
	}

	public User name(String name) {
		this.name = name;
		return this;
	}
	
	public String getMobile() {
		return this.mobile;
	}
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String mobile() {
		return this.mobile;
	}

	public User mobile(String mobile) {
		this.mobile = mobile;
		return this;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String email() {
		return this.email;
	}

	public User email(String email) {
		this.email = email;
		return this;
	}
	
	public String getRemarks() {
		return this.remarks;
	}
	
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	public String remarks() {
		return this.remarks;
	}

	public User remarks(String remarks) {
		this.remarks = remarks;
		return this;
	}
	
	public Integer getEnabled() {
		return this.enabled;
	}
	
	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}
	
	public Integer enabled() {
		return this.enabled;
	}

	public User enabled(Integer enabled) {
		this.enabled = enabled;
		return this;
	}
	

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getAccount())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj instanceof User == false) return false;
		User other = (User)obj;
		return new EqualsBuilder()
			.append(getAccount(),other.getAccount())
			.isEquals();
	}
}

