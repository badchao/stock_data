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
 * [Stock] 查询对象
 * 
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */
public class StockQuery extends PageQuery implements Serializable {
    private static final long serialVersionUID = 3148176768559230877L;
    

	/** 股票ID */
	private String stockId;
	/** 股票代码 */
	private String stockCode;
	/** 股票名称 */
	private String stockName;
	/** 股票市场 */
	private String market;
	/** 股票区域 */
	private String zone;
	/** 股票备注 */
	private String remarks;

	public String getStockId() {
		return this.stockId;
	}
	
	public StockQuery setStockId(String stockId) {
		this.stockId = stockId;
		return this;
	}
	
	public String stockId() {
		return this.stockId;
	}

	public StockQuery stockId(String stockId) {
		this.stockId = stockId;
		return this;
	}
	
	public String getStockCode() {
		return this.stockCode;
	}
	
	public StockQuery setStockCode(String stockCode) {
		this.stockCode = stockCode;
		return this;
	}
	
	public String stockCode() {
		return this.stockCode;
	}

	public StockQuery stockCode(String stockCode) {
		this.stockCode = stockCode;
		return this;
	}
	
	public String getStockName() {
		return this.stockName;
	}
	
	public StockQuery setStockName(String stockName) {
		this.stockName = stockName;
		return this;
	}
	
	public String stockName() {
		return this.stockName;
	}

	public StockQuery stockName(String stockName) {
		this.stockName = stockName;
		return this;
	}
	
	public String getMarket() {
		return this.market;
	}
	
	public StockQuery setMarket(String market) {
		this.market = market;
		return this;
	}
	
	public String market() {
		return this.market;
	}

	public StockQuery market(String market) {
		this.market = market;
		return this;
	}
	
	public String getZone() {
		return this.zone;
	}
	
	public StockQuery setZone(String zone) {
		this.zone = zone;
		return this;
	}
	
	public String zone() {
		return this.zone;
	}

	public StockQuery zone(String zone) {
		this.zone = zone;
		return this;
	}
	
	public String getRemarks() {
		return this.remarks;
	}
	
	public StockQuery setRemarks(String remarks) {
		this.remarks = remarks;
		return this;
	}
	
	public String remarks() {
		return this.remarks;
	}

	public StockQuery remarks(String remarks) {
		this.remarks = remarks;
		return this;
	}
	

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
}

