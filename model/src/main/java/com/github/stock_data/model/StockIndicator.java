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
 * tableName: stock_indicator [StockIndicator] 
 * 
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */
public class StockIndicator  implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//date formats
	public static final String FORMAT_TDATE = "yyyy-MM-dd";
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * 股票ID       db_column: stock_id 
     */ 	
	@Length(max=30)
	private String stockId;
	
    /**
     * 指标ID       db_column: indicator_id 
     */ 	
	@Length(max=30)
	private String indicatorId;
	
    /**
     * 日期       db_column: tdate 
     */ 	
	
	private java.util.Date tdate;
	
    /**
     * 日期类型       db_column: tdate_type 
     */ 	
	@Length(max=30)
	private String tdateType;
	
    /**
     * 爬取URL       db_column: val 
     */ 	
	
	private java.lang.Float val;
	
    /**
     * 扩展字段       db_column: ext 
     */ 	
	@Length(max=500)
	private String ext;
	
	private Date updateTime;
	
	//columns END

	public StockIndicator(){
	}

	public StockIndicator(
		String stockId,
		String indicatorId,
		java.util.Date tdate,
		String tdateType
	){
		this.stockId = stockId;
		this.indicatorId = indicatorId;
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

	public StockIndicator stockId(String stockId) {
		this.stockId = stockId;
		return this;
	}
	
	public String getIndicatorId() {
		return this.indicatorId;
	}
	
	public void setIndicatorId(String indicatorId) {
		this.indicatorId = indicatorId;
	}
	
	public String indicatorId() {
		return this.indicatorId;
	}

	public StockIndicator indicatorId(String indicatorId) {
		this.indicatorId = indicatorId;
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

	public StockIndicator tdate(java.util.Date tdate) {
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

	public StockIndicator tdateType(String tdateType) {
		this.tdateType = tdateType;
		return this;
	}
	
	public java.lang.Float getVal() {
		return this.val;
	}
	
	public void setVal(java.lang.Float val) {
		this.val = val;
	}
	
	public java.lang.Float val() {
		return this.val;
	}

	public StockIndicator val(java.lang.Float val) {
		this.val = val;
		return this;
	}
	
	public String getExt() {
		return this.ext;
	}
	
	public void setExt(String ext) {
		this.ext = ext;
	}
	
	public String ext() {
		return this.ext;
	}

	public StockIndicator ext(String ext) {
		this.ext = ext;
		return this;
	}
	
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getStockId())
			.append(getIndicatorId())
			.append(getTdate())
			.append(getTdateType())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj instanceof StockIndicator == false) return false;
		StockIndicator other = (StockIndicator)obj;
		return new EqualsBuilder()
			.append(getStockId(),other.getStockId())
			.append(getIndicatorId(),other.getIndicatorId())
			.append(getTdate(),other.getTdate())
			.append(getTdateType(),other.getTdateType())
			.isEquals();
	}
}

