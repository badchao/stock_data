package com.github.stock_data.cron_job;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.github.rapid.common.util.DateConvertUtil;
import com.github.sqlrunner.datax.SqlRunnerMain;

@Service
public class SqlRunnerJob {

	@Scheduled(cron="1 50 3,8,12 * * *")
	public void exec() throws Exception {
		SqlRunnerMain main = new SqlRunnerMain();
		System.setProperty("springConfigDir", "classpath*:spring/*.xml");
//		System.setProperty("configDir", "classpath:sqlrunner");
		System.setProperty("configDir", "/data/app/stock_data/config/sqlrunner/");
		System.setProperty("day", DateConvertUtil.format(new Date(),"yyyy-MM-dd"));
		System.setProperty("jobId", "stock_indicator");
		
		main.main(new String[0]);
	}
	
}
