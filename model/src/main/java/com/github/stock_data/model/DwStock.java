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
 * tableName: dw_stock [DwStock] 
 * 
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */
public class DwStock  implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//date formats
	public static final String FORMAT_TDATE = "yyyy-MM-dd";
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * stockId       db_column: stock_id 
     */ 	
	@Length(max=20)
	private String stockId;
	
    /**
     * tdate       db_column: tdate 
     */ 	
	
	private java.util.Date tdate;
	
    /**
     * tdateType       db_column: tdate_type 
     */ 	
	@Length(max=50)
	private String tdateType;
	
    /**
     * pe       db_column: pe 
     */ 	
	
	private java.lang.Float pe;
	
    /**
     * pb       db_column: pb 
     */ 	
	
	private java.lang.Float pb;
	
    /**
     * reverce       db_column: reverce 
     */ 	
	
	private java.lang.Float reverce;
	
    /**
     * companyValue       db_column: company_value 
     */ 	
	
	private java.lang.Float companyValue;
	
	//columns END

	public DwStock(){
	}

	public DwStock(
		String stockId,
		java.util.Date tdate,
		String tdateType
	){
		this.stockId = stockId;
		this.tdate = tdate;
		this.tdateType = tdateType;
	}

	public String getStockId() {
		return this.stockId;
	}
	
	public void setStockId(String stockId) {
		this.stockId = stockId;
	}
	
	public String stockId() {
		return this.stockId;
	}

	public DwStock stockId(String stockId) {
		this.stockId = stockId;
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

	public DwStock tdate(java.util.Date tdate) {
		this.tdate = tdate;
		return this;
	}
	
	public String getTdateType() {
		return this.tdateType;
	}
	
	public void setTdateType(String tdateType) {
		this.tdateType = tdateType;
	}
	
	public String tdateType() {
		return this.tdateType;
	}

	public DwStock tdateType(String tdateType) {
		this.tdateType = tdateType;
		return this;
	}
	
	public java.lang.Float getPe() {
		return this.pe;
	}
	
	public void setPe(java.lang.Float pe) {
		this.pe = pe;
	}
	
	public java.lang.Float pe() {
		return this.pe;
	}

	public DwStock pe(java.lang.Float pe) {
		this.pe = pe;
		return this;
	}
	
	public java.lang.Float getPb() {
		return this.pb;
	}
	
	public void setPb(java.lang.Float pb) {
		this.pb = pb;
	}
	
	public java.lang.Float pb() {
		return this.pb;
	}

	public DwStock pb(java.lang.Float pb) {
		this.pb = pb;
		return this;
	}
	
	public java.lang.Float getReverce() {
		return this.reverce;
	}
	
	public void setReverce(java.lang.Float reverce) {
		this.reverce = reverce;
	}
	
	public java.lang.Float reverce() {
		return this.reverce;
	}

	public DwStock reverce(java.lang.Float reverce) {
		this.reverce = reverce;
		return this;
	}
	
	public java.lang.Float getCompanyValue() {
		return this.companyValue;
	}
	
	public void setCompanyValue(java.lang.Float companyValue) {
		this.companyValue = companyValue;
	}
	
	public java.lang.Float companyValue() {
		return this.companyValue;
	}

	public DwStock companyValue(java.lang.Float companyValue) {
		this.companyValue = companyValue;
		return this;
	}
	

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getStockId())
			.append(getTdate())
			.append(getTdateType())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj instanceof DwStock == false) return false;
		DwStock other = (DwStock)obj;
		return new EqualsBuilder()
			.append(getStockId(),other.getStockId())
			.append(getTdate(),other.getTdate())
			.append(getTdateType(),other.getTdateType())
			.isEquals();
	}
}

