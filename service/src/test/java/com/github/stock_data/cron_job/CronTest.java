package com.github.stock_data.cron_job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class CronTest {

	@Scheduled(cron="* * * * * *")
	public void print() throws Exception {
		System.out.println("CronTest.print()");
	}
	
	@Scheduled(cron="* * * * * *")
	public void exception() throws Exception {
		System.out.println("CronTest.exception()");
		throw new RuntimeException("exception()");
	}
		
	
	@Scheduled(cron="* * * * * *")
	public void error() throws Exception {
		System.out.println("CronTest.error()");
		throw new Error("Error()");
	}
}
