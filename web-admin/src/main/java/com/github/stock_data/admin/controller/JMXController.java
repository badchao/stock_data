package com.github.stock_data.admin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.rapid.common.web.scope.Flash;
import com.github.stock_data.cron_job.SqlRunnerJob;
import com.github.stock_data.cron_job.StockIndicatorCrawlJob;

@Controller
@RequestMapping("/admin/jmx")
public class JMXController {

	@Autowired
	private StockIndicatorCrawlJob stockIndicatorCrawlJob;
	
	@Autowired
	private SqlRunnerJob sqlRunnerJob;
	
	
	@RequestMapping
	public String stockIndicatorCrawlJob(HttpServletRequest request) {
		stockIndicatorCrawlJob.exec();
		Flash.current().success("stockIndicatorCrawlJob executed");
		return "redirect:"+request.getHeader("Referer");
	}
	
	@RequestMapping
	public String sqlRunnerJob(HttpServletRequest request) throws Exception {
		sqlRunnerJob.exec();
		Flash.current().success("sqlRunnerJob executed");
		return "redirect:"+request.getHeader("Referer");
	}
	
}
