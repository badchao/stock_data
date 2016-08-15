package com.github.stock_data.admin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.stock_data.cron_job.StockIndicatorCrawlJob;

@Controller
@RequestMapping("/admin/jmx")
public class JMXController {

	@Autowired
	private StockIndicatorCrawlJob stockIndicatorCrawlJob;
	
	@RequestMapping
	public String stockIndicatorCrawlJob(HttpServletRequest request) {
		stockIndicatorCrawlJob.exec();
		return "redirect:"+request.getHeader("Referer");
	}
	
}
