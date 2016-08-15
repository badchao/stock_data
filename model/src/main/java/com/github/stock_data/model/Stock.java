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
 * tableName: stock [Stock] 
 * 
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */
public class Stock  implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//date formats
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * 股票ID       db_column: stock_id 
     */ 	
	@Length(max=30)
	private String stockId;
	
    /**
     * 股票代码       db_column: stock_code 
     */ 	
	@Length(max=30)
	private String stockCode;
	
    /**
     * 股票名称       db_column: stock_name 
     */ 	
	@Length(max=50)
	private String stockName;
	
    /**
     * 股票市场       db_column: market 
     */ 	
	@Length(max=50)
	private String market;
	
    /**
     * 股票区域       db_column: zone 
     */ 	
	@Length(max=50)
	private String zone;
	
    /**
     * 股票备注       db_column: remarks 
     */ 	
	@Length(max=50)
	private String remarks;
	
	//columns END

	public Stock(){
	}

	public Stock(
		String stockId
	){
		this.stockId = stockId;
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

	public Stock stockId(String stockId) {
		this.stockId = stockId;
		return this;
	}
	
	public String getStockCode() {
		return this.stockCode;
	}
	
	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}
	
	public String stockCode() {
		return this.stockCode;
	}

	public Stock stockCode(String stockCode) {
		this.stockCode = stockCode;
		return this;
	}
	
	public String getStockName() {
		return this.stockName;
	}
	
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	
	public String stockName() {
		return this.stockName;
	}

	public Stock stockName(String stockName) {
		this.stockName = stockName;
		return this;
	}
	
	public String getMarket() {
		return this.market;
	}
	
	public void setMarket(String market) {
		this.market = market;
	}
	
	public String market() {
		return this.market;
	}

	public Stock market(String market) {
		this.market = market;
		return this;
	}
	
	public String getZone() {
		return this.zone;
	}
	
	public void setZone(String zone) {
		this.zone = zone;
	}
	
	public String zone() {
		return this.zone;
	}

	public Stock zone(String zone) {
		this.zone = zone;
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

	public Stock remarks(String remarks) {
		this.remarks = remarks;
		return this;
	}
	

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getStockId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj instanceof Stock == false) return false;
		Stock other = (Stock)obj;
		return new EqualsBuilder()
			.append(getStockId(),other.getStockId())
			.isEquals();
	}
}

