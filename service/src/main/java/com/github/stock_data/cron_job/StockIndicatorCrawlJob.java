package com.github.stock_data.cron_job;

import java.util.Date;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.github.rapid.common.util.DateConvertUtil;
import com.github.rapid.common.util.page.Page;
import com.github.stock_data.enums.TdateType;
import com.github.stock_data.model.StockIndicator;
import com.github.stock_data.model.StockIndicatorConfig;
import com.github.stock_data.query.StockIndicatorConfigQuery;
import com.github.stock_data.service.StockIndicatorConfigService;
import com.github.stock_data.service.StockIndicatorService;
import com.github.stock_data.service.impl.StockIndicatorCrawler;

@Service("stockIndicatorCrawlJob")
public class StockIndicatorCrawlJob {

	private StockIndicatorConfigService stockIndicatorConfigService;
	private StockIndicatorService stockIndicatorService;
	
	public void setStockIndicatorConfigService(StockIndicatorConfigService stockIndicatorConfigService) {
		this.stockIndicatorConfigService = stockIndicatorConfigService;
	}
	
	public void setStockIndicatorService(StockIndicatorService stockIndicatorService) {
		this.stockIndicatorService = stockIndicatorService;
	}

	@Scheduled(cron="1 1 3,8,10,12,15,19,22 * * *")
	public void exec() {
		StockIndicatorConfigQuery query = new StockIndicatorConfigQuery();
		query.setPageSize(1000);
		
		Page<StockIndicatorConfig> page = stockIndicatorConfigService.findPage(query);
		
		for(int i = 1; i <= page.getPaginator().getTotalPages(); i++) {
			query.setPage(i);
			page = stockIndicatorConfigService.findPage(query);
			crawlAll(page);
		}
		
	}

	private void crawlAll(Page<StockIndicatorConfig> page) {
		StockIndicatorCrawler stockIndicatorCrawler = new StockIndicatorCrawler();
		
		for(StockIndicatorConfig sic : page) {
			try {
				Object result = stockIndicatorCrawler.evalCrawlScript(sic);
				insertInto(toNumber(result),sic);
				sic.setCrawlStatus("success");
				sic.setCrawlLog("");
			}catch(Exception e) {
				sic.setCrawlStatus("danger");
				sic.setCrawlLog(ExceptionUtils.getFullStackTrace(e).substring(0,3999));
				e.printStackTrace();
			}
			sic.setLastCrawlTime(new Date());
			
			stockIndicatorConfigService.update(sic);
		}
	}

	public static Number toNumber(Object num) {
		if(num == null) return 0;
		String str = num.toString();
		if(StringUtils.isBlank(str)) return 0;
		return Double.parseDouble(str);
	}

	private void insertInto(Number result, StockIndicatorConfig sic) {
		StockIndicator si = new StockIndicator();
		si.setIndicatorId(sic.getIndicatorId());
		si.setStockId(sic.getStockId());
		si.setTdate(DateConvertUtil.extract(new Date(),"yyyyMMdd"));
		si.setTdateType(TdateType.day.getCode());
		si.setVal(result == null ? 0 : result.floatValue());
		StockIndicator fromDb = stockIndicatorService.getById(si.getStockId(), si.getIndicatorId(), si.getTdate(), si.getTdateType());
		if(fromDb == null) {
			stockIndicatorService.create(si);
		}else {
			stockIndicatorService.update(si);
		}
//		si.setExt("");
	}
}
