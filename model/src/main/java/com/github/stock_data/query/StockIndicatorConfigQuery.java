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
 * [StockIndicatorConfig] 查询对象
 * 
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */
public class StockIndicatorConfigQuery extends PageQuery implements Serializable {
    private static final long serialVersionUID = 3148176768559230877L;
    

	/** 股票ID */
	private String stockId;
	/** 指标ID */
	private String indicatorId;
	/** 指标名称 */
	private String indicatorName;
	/** 爬取URL */
	private String crawlUrl;
	/** 爬取脚本 */
	private String crawlScript;
	/** 爬取Cron */
	private String crawlCron;
	/** 计算表达式 */
	private String calcExpr;
	/** remarks */
	private String remarks;

	public String getStockId() {
		return this.stockId;
	}
	
	public StockIndicatorConfigQuery setStockId(String stockId) {
		this.stockId = stockId;
		return this;
	}
	
	public String stockId() {
		return this.stockId;
	}

	public StockIndicatorConfigQuery stockId(String stockId) {
		this.stockId = stockId;
		return this;
	}
	
	public String getIndicatorId() {
		return this.indicatorId;
	}
	
	public StockIndicatorConfigQuery setIndicatorId(String indicatorId) {
		this.indicatorId = indicatorId;
		return this;
	}
	
	public String indicatorId() {
		return this.indicatorId;
	}

	public StockIndicatorConfigQuery indicatorId(String indicatorId) {
		this.indicatorId = indicatorId;
		return this;
	}
	
	public String getIndicatorName() {
		return this.indicatorName;
	}
	
	public StockIndicatorConfigQuery setIndicatorName(String indicatorName) {
		this.indicatorName = indicatorName;
		return this;
	}
	
	public String indicatorName() {
		return this.indicatorName;
	}

	public StockIndicatorConfigQuery indicatorName(String indicatorName) {
		this.indicatorName = indicatorName;
		return this;
	}
	
	public String getCrawlUrl() {
		return this.crawlUrl;
	}
	
	public StockIndicatorConfigQuery setCrawlUrl(String crawlUrl) {
		this.crawlUrl = crawlUrl;
		return this;
	}
	
	public String crawlUrl() {
		return this.crawlUrl;
	}

	public StockIndicatorConfigQuery crawlUrl(String crawlUrl) {
		this.crawlUrl = crawlUrl;
		return this;
	}
	
	public String getCrawlScript() {
		return this.crawlScript;
	}
	
	public StockIndicatorConfigQuery setCrawlScript(String crawlScript) {
		this.crawlScript = crawlScript;
		return this;
	}
	
	public String crawlScript() {
		return this.crawlScript;
	}

	public StockIndicatorConfigQuery crawlScript(String crawlScript) {
		this.crawlScript = crawlScript;
		return this;
	}
	
	public String getCrawlCron() {
		return this.crawlCron;
	}
	
	public StockIndicatorConfigQuery setCrawlCron(String crawlCron) {
		this.crawlCron = crawlCron;
		return this;
	}
	
	public String crawlCron() {
		return this.crawlCron;
	}

	public StockIndicatorConfigQuery crawlCron(String crawlCron) {
		this.crawlCron = crawlCron;
		return this;
	}
	
	public String getCalcExpr() {
		return this.calcExpr;
	}
	
	public StockIndicatorConfigQuery setCalcExpr(String calcExpr) {
		this.calcExpr = calcExpr;
		return this;
	}
	
	public String calcExpr() {
		return this.calcExpr;
	}

	public StockIndicatorConfigQuery calcExpr(String calcExpr) {
		this.calcExpr = calcExpr;
		return this;
	}
	
	public String getRemarks() {
		return this.remarks;
	}
	
	public StockIndicatorConfigQuery setRemarks(String remarks) {
		this.remarks = remarks;
		return this;
	}
	
	public String remarks() {
		return this.remarks;
	}

	public StockIndicatorConfigQuery remarks(String remarks) {
		this.remarks = remarks;
		return this;
	}
	

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
}

