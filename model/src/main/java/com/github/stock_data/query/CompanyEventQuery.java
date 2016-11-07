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
 * [CompanyEvent] 查询对象
 * 
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */
public class CompanyEventQuery extends PageQuery implements Serializable {
    private static final long serialVersionUID = 3148176768559230877L;
    

	/** id */
	private Long id;
	/** 日期 */
	private java.util.Date tdateBegin;
	private java.util.Date tdateEnd;
	/** 公司 */
	private String companyName;
	/** 事件内容 */
	private String stockEvent;
	/** 关联公司 */
	private String relateCompany;
	/** 备注 */
	private String remarks;
	/** 重新关注日期 */
	private java.util.Date attentionDateBegin;
	private java.util.Date attentionDateEnd;
	/** 关联股票 */
	private String relateStock;

	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long id() {
		return this.id;
	}

	public CompanyEventQuery id(Long id) {
		this.id = id;
		return this;
	}
	
	public java.util.Date getTdateBegin() {
		return this.tdateBegin;
	}
	
	public void setTdateBegin(java.util.Date value) {
		this.tdateBegin = value;
	}	
	
	public java.util.Date getTdateEnd() {
		return this.tdateEnd;
	}
	
	public void setTdateEnd(java.util.Date value) {
		this.tdateEnd = value;
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

	public CompanyEventQuery companyName(String companyName) {
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

	public CompanyEventQuery stockEvent(String stockEvent) {
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

	public CompanyEventQuery relateCompany(String relateCompany) {
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

	public CompanyEventQuery remarks(String remarks) {
		this.remarks = remarks;
		return this;
	}
	
	public java.util.Date getAttentionDateBegin() {
		return this.attentionDateBegin;
	}
	
	public void setAttentionDateBegin(java.util.Date value) {
		this.attentionDateBegin = value;
	}	
	
	public java.util.Date getAttentionDateEnd() {
		return this.attentionDateEnd;
	}
	
	public void setAttentionDateEnd(java.util.Date value) {
		this.attentionDateEnd = value;
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

	public CompanyEventQuery relateStock(String relateStock) {
		this.relateStock = relateStock;
		return this;
	}
	

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
}

