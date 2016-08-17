package com.github.stock_data;

import com.github.sqlrunner.datax.SqlRunnerMain;


public class SqlRunnerDebug {

	public static void main(String[] args) throws Exception {
		SqlRunnerMain main = new SqlRunnerMain();
		System.setProperty("springConfigDir", "classpath:spring/*.xml");
		System.setProperty("configDir", "classpath:sqlrunner/");
		System.setProperty("day", "2016-08-15");
		System.setProperty("jobId", "stock_indicator");
		
		main.main(new String[0]);
	}
}
