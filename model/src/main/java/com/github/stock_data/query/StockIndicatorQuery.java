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
 * [StockIndicator] 查询对象
 * 
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */
public class StockIndicatorQuery extends PageQuery implements Serializable {
    private static final long serialVersionUID = 3148176768559230877L;
    

	/** 股票ID */
	private String stockId;
	/** 指标ID */
	private String indicatorId;
	/** 日期 */
	private java.util.Date tdateBegin;
	private java.util.Date tdateEnd;
	/** 日期类型 */
	private String tdateType;
	/** 爬取URL */
	private java.lang.Float val;
	/** 扩展字段 */
	private String ext;

	public String getStockId() {
		return this.stockId;
	}
	
	public StockIndicatorQuery setStockId(String stockId) {
		this.stockId = stockId;
		return this;
	}
	
	public String stockId() {
		return this.stockId;
	}

	public StockIndicatorQuery stockId(String stockId) {
		this.stockId = stockId;
		return this;
	}
	
	public String getIndicatorId() {
		return this.indicatorId;
	}
	
	public StockIndicatorQuery setIndicatorId(String indicatorId) {
		this.indicatorId = indicatorId;
		return this;
	}
	
	public String indicatorId() {
		return this.indicatorId;
	}

	public StockIndicatorQuery indicatorId(String indicatorId) {
		this.indicatorId = indicatorId;
		return this;
	}
	
	public java.util.Date getTdateBegin() {
		return this.tdateBegin;
	}
	
	public StockIndicatorQuery setTdateBegin(java.util.Date value) {
		this.tdateBegin = value;
		return this;
	}	
	
	public java.util.Date getTdateEnd() {
		return this.tdateEnd;
	}
	
	public StockIndicatorQuery setTdateEnd(java.util.Date value) {
		this.tdateEnd = value;
		return this;
	}
	
	public String getTdateType() {
		return this.tdateType;
	}
	
	public StockIndicatorQuery setTdateType(String tdateType) {
		this.tdateType = tdateType;
		return this;
	}
	
	public String tdateType() {
		return this.tdateType;
	}

	public StockIndicatorQuery tdateType(String tdateType) {
		this.tdateType = tdateType;
		return this;
	}
	
	public java.lang.Float getVal() {
		return this.val;
	}
	
	public StockIndicatorQuery setVal(java.lang.Float val) {
		this.val = val;
		return this;
	}
	
	public java.lang.Float val() {
		return this.val;
	}

	public StockIndicatorQuery val(java.lang.Float val) {
		this.val = val;
		return this;
	}
	
	public String getExt() {
		return this.ext;
	}
	
	public StockIndicatorQuery setExt(String ext) {
		this.ext = ext;
		return this;
	}
	
	public String ext() {
		return this.ext;
	}

	public StockIndicatorQuery ext(String ext) {
		this.ext = ext;
		return this;
	}
	

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
}

