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
 * [DwStock] 查询对象
 * 
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */
public class DwStockQuery extends PageQuery implements Serializable {
    private static final long serialVersionUID = 3148176768559230877L;
    

	/** stockId */
	private String stockId;
	/** tdate */
	private java.util.Date tdateBegin;
	private java.util.Date tdateEnd;
	/** tdateType */
	private String tdateType;
	/** pe */
	private java.lang.Float pe;
	/** pb */
	private java.lang.Float pb;
	/** reverce */
	private java.lang.Float reverce;
	/** companyValue */
	private java.lang.Float companyValue;

	public String getStockId() {
		return this.stockId;
	}
	
	public DwStockQuery setStockId(String stockId) {
		this.stockId = stockId;
		return this;
	}
	
	public String stockId() {
		return this.stockId;
	}

	public DwStockQuery stockId(String stockId) {
		this.stockId = stockId;
		return this;
	}
	
	public java.util.Date getTdateBegin() {
		return this.tdateBegin;
	}
	
	public DwStockQuery setTdateBegin(java.util.Date value) {
		this.tdateBegin = value;
		return this;
	}	
	
	public java.util.Date getTdateEnd() {
		return this.tdateEnd;
	}
	
	public DwStockQuery setTdateEnd(java.util.Date value) {
		this.tdateEnd = value;
		return this;
	}
	
	public String getTdateType() {
		return this.tdateType;
	}
	
	public DwStockQuery setTdateType(String tdateType) {
		this.tdateType = tdateType;
		return this;
	}
	
	public String tdateType() {
		return this.tdateType;
	}

	public DwStockQuery tdateType(String tdateType) {
		this.tdateType = tdateType;
		return this;
	}
	
	public java.lang.Float getPe() {
		return this.pe;
	}
	
	public DwStockQuery setPe(java.lang.Float pe) {
		this.pe = pe;
		return this;
	}
	
	public java.lang.Float pe() {
		return this.pe;
	}

	public DwStockQuery pe(java.lang.Float pe) {
		this.pe = pe;
		return this;
	}
	
	public java.lang.Float getPb() {
		return this.pb;
	}
	
	public DwStockQuery setPb(java.lang.Float pb) {
		this.pb = pb;
		return this;
	}
	
	public java.lang.Float pb() {
		return this.pb;
	}

	public DwStockQuery pb(java.lang.Float pb) {
		this.pb = pb;
		return this;
	}
	
	public java.lang.Float getReverce() {
		return this.reverce;
	}
	
	public DwStockQuery setReverce(java.lang.Float reverce) {
		this.reverce = reverce;
		return this;
	}
	
	public java.lang.Float reverce() {
		return this.reverce;
	}

	public DwStockQuery reverce(java.lang.Float reverce) {
		this.reverce = reverce;
		return this;
	}
	
	public java.lang.Float getCompanyValue() {
		return this.companyValue;
	}
	
	public DwStockQuery setCompanyValue(java.lang.Float companyValue) {
		this.companyValue = companyValue;
		return this;
	}
	
	public java.lang.Float companyValue() {
		return this.companyValue;
	}

	public DwStockQuery companyValue(java.lang.Float companyValue) {
		this.companyValue = companyValue;
		return this;
	}
	

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
}

