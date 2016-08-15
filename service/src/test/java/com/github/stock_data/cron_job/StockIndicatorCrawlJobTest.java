package com.github.stock_data.cron_job;

import static org.junit.Assert.*;

import org.junit.Test;

public class StockIndicatorCrawlJobTest {

	@Test
	public void test() {
		StockIndicatorCrawlJob job = new StockIndicatorCrawlJob();
		
		job.exec();
	}

}
