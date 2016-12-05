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
import org.apache.commons.lang3.builder.CompareToBuilder;



/**
 * tableName: company_event [CompanyEvent] 
 * 
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */
public class CompanyEvent  implements java.io.Serializable,Comparable<CompanyEvent>{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//date formats
	public static final String FORMAT_TDATE = "yyyy-MM-dd";
	public static final String FORMAT_ATTENTION_DATE = "yyyy-MM-dd";
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * id       db_column: id 
     */ 	
	@Max(9223372036854775807L)
	private Long id;
	
    /**
     * 日期       db_column: tdate 
     */ 	
	@NotNull 
	private java.util.Date tdate;
	
    /**
     * 公司       db_column: company_name 
     */ 	
	@NotBlank @Length(max=255)
	private String companyName;
	
    /**
     * 事件内容       db_column: stock_event 
     */ 	
	@Length(max=4000)
	private String stockEvent;
	
    /**
     * 关联公司       db_column: relate_company 
     */ 	
	@Length(max=2000)
	private String relateCompany;
	
    /**
     * 备注       db_column: remarks 
     */ 	
	@Length(max=2000)
	private String remarks;
	
    /**
     * 重新关注日期       db_column: attention_date 
     */ 	
	
	private java.util.Date attentionDate;
	
    /**
     * 关联股票       db_column: relate_stock 
     */ 	
	@Length(max=255)
	private String relateStock;
	
	//columns END

	public CompanyEvent(){
	}

	public CompanyEvent(
		Long id
	){
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long id() {
		return this.id;
	}

	public CompanyEvent id(Long id) {
		this.id = id;
		return this;
	}
	
	public java.util.Date getTdate() {
		return this.tdate;
	}
	
	public void setTdate(java.util.Date tdate) {
		this.tdate = tdate;
	}
	
	public java.util.Date tdate() {
		return this.tdate;
	}

	public CompanyEvent tdate(java.util.Date tdate) {
		this.tdate = tdate;
		return this;
	}
	
	public String getCompanyName() {
		return this.companyName;
	}
	
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	public String companyName() {
		return this.companyName;
	}

	public CompanyEvent companyName(String companyName) {
		this.companyName = companyName;
		return this;
	}
	
	public String getStockEvent() {
		return this.stockEvent;
	}
	
	public void setStockEvent(String stockEvent) {
		this.stockEvent = stockEvent;
	}
	
	public String stockEvent() {
		return this.stockEvent;
	}

	public CompanyEvent stockEvent(String stockEvent) {
		this.stockEvent = stockEvent;
		return this;
	}
	
	public String getRelateCompany() {
		return this.relateCompany;
	}
	
	public void setRelateCompany(String relateCompany) {
		this.relateCompany = relateCompany;
	}
	
	public String relateCompany() {
		return this.relateCompany;
	}

	public CompanyEvent relateCompany(String relateCompany) {
		this.relateCompany = relateCompany;
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

	public CompanyEvent remarks(String remarks) {
		this.remarks = remarks;
		return this;
	}
	
	public java.util.Date getAttentionDate() {
		return this.attentionDate;
	}
	
	public void setAttentionDate(java.util.Date attentionDate) {
		this.attentionDate = attentionDate;
	}
	
	public java.util.Date attentionDate() {
		return this.attentionDate;
	}

	public CompanyEvent attentionDate(java.util.Date attentionDate) {
		this.attentionDate = attentionDate;
		return this;
	}
	
	public String getRelateStock() {
		return this.relateStock;
	}
	
	public void setRelateStock(String relateStock) {
		this.relateStock = relateStock;
	}
	
	public String relateStock() {
		return this.relateStock;
	}

	public CompanyEvent relateStock(String relateStock) {
		this.relateStock = relateStock;
		return this;
	}
	
	public long getAttentionDays() {
		if(attentionDate == null) return 0;
		
		long intervalMills = attentionDate.getTime() - new Date().getTime();
		return intervalMills/(3600 * 1000 * 24);
	}
	

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj instanceof CompanyEvent == false) return false;
		CompanyEvent other = (CompanyEvent)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}

	@Override
	public int compareTo(CompanyEvent o) {
		return new Long(getAttentionDays()).compareTo(o.getAttentionDays());
	}
	
}

