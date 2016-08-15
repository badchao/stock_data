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
 * tableName: stock_indicator_config [StockIndicatorConfig] 
 * 
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */
public class StockIndicatorConfig  implements java.io.Serializable{
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
     * 指标ID       db_column: indicator_id 
     */ 	
	@Length(max=30)
	private String indicatorId;
	
    /**
     * 指标名称       db_column: indicator_name 
     */ 	
	@Length(max=300)
	private String indicatorName;
	
    /**
     * 爬取URL       db_column: crawl_url 
     */ 	
	@Length(max=300)
	private String crawlUrl;
	
    /**
     * 爬取脚本       db_column: crawl_script 
     */ 	
	@Length(max=4000)
	private String crawlScript;
	
    /**
     * 爬取Cron       db_column: crawl_cron 
     */ 	
	@Length(max=300)
	private String crawlCron;
	
    /**
     * 计算表达式       db_column: calc_expr 
     */ 	
	@Length(max=4000)
	private String calcExpr;
	
    /**
     * remarks       db_column: remarks 
     */ 	
	@Length(max=200)
	private String remarks;
	
	private String crawlStatus;
	private String crawlLog;
	private Date lastCrawlTime;
	//columns END

	public StockIndicatorConfig(){
	}

	public StockIndicatorConfig(
		String stockId,
		String indicatorId
	){
		this.stockId = stockId;
		this.indicatorId = indicatorId;
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

	public StockIndicatorConfig stockId(String stockId) {
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

	public StockIndicatorConfig indicatorId(String indicatorId) {
		this.indicatorId = indicatorId;
		return this;
	}
	
	public String getIndicatorName() {
		return this.indicatorName;
	}
	
	public void setIndicatorName(String indicatorName) {
		this.indicatorName = indicatorName;
	}
	
	public String indicatorName() {
		return this.indicatorName;
	}

	public StockIndicatorConfig indicatorName(String indicatorName) {
		this.indicatorName = indicatorName;
		return this;
	}
	
	public String getCrawlUrl() {
		return this.crawlUrl;
	}
	
	public void setCrawlUrl(String crawlUrl) {
		this.crawlUrl = crawlUrl;
	}
	
	public String crawlUrl() {
		return this.crawlUrl;
	}

	public StockIndicatorConfig crawlUrl(String crawlUrl) {
		this.crawlUrl = crawlUrl;
		return this;
	}
	
	public String getCrawlScript() {
		return this.crawlScript;
	}
	
	public void setCrawlScript(String crawlScript) {
		this.crawlScript = crawlScript;
	}
	
	public String crawlScript() {
		return this.crawlScript;
	}

	public StockIndicatorConfig crawlScript(String crawlScript) {
		this.crawlScript = crawlScript;
		return this;
	}
	
	public String getCrawlCron() {
		return this.crawlCron;
	}
	
	public void setCrawlCron(String crawlCron) {
		this.crawlCron = crawlCron;
	}
	
	public String crawlCron() {
		return this.crawlCron;
	}

	public StockIndicatorConfig crawlCron(String crawlCron) {
		this.crawlCron = crawlCron;
		return this;
	}
	
	public String getCalcExpr() {
		return this.calcExpr;
	}
	
	public void setCalcExpr(String calcExpr) {
		this.calcExpr = calcExpr;
	}
	
	public String calcExpr() {
		return this.calcExpr;
	}

	public StockIndicatorConfig calcExpr(String calcExpr) {
		this.calcExpr = calcExpr;
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
	
	public String getCrawlStatus() {
		return crawlStatus;
	}

	public void setCrawlStatus(String crawlStatus) {
		this.crawlStatus = crawlStatus;
	}

	public String getCrawlLog() {
		return crawlLog;
	}

	public void setCrawlLog(String crawlLog) {
		this.crawlLog = crawlLog;
	}

	public StockIndicatorConfig remarks(String remarks) {
		this.remarks = remarks;
		return this;
	}
	
	public Date getLastCrawlTime() {
		return lastCrawlTime;
	}

	public void setLastCrawlTime(Date lastCrawlTime) {
		this.lastCrawlTime = lastCrawlTime;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getStockId())
			.append(getIndicatorId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj instanceof StockIndicatorConfig == false) return false;
		StockIndicatorConfig other = (StockIndicatorConfig)obj;
		return new EqualsBuilder()
			.append(getStockId(),other.getStockId())
			.append(getIndicatorId(),other.getIndicatorId())
			.isEquals();
	}
}

