package com.github.stock_data.service.impl;

import java.io.IOException;
import java.util.Map;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import com.github.stock_data.model.StockIndicatorConfig;

public class StockIndicatorCrawlerTest {
	ObjectMapper objectMapper = new ObjectMapper();
	@Test
	public void test() throws Exception {
		Map json = objectMapper.readValue("{\"name\":1}", Map.class);
		System.out.println(json);
		Object json2 = objectMapper.readValue("[1,2,3,{\"name\":\"badqiu\"}]", Object.class);
		System.out.println(json2);
	}
	
	@Test
	public void test2() throws Exception {
		StockIndicatorCrawler c = new StockIndicatorCrawler();
		StockIndicatorConfig conf = new StockIndicatorConfig();
		conf.setCrawlUrl("https://www.yirendai.com/home/index");
		conf.setCrawlScript("return plainJson.get('borrowPerson');");
//		conf.setCrawlScript("return _.getElementById(plainJson,'borrowPerson')");
		conf.setCrawlScript("return json");
		System.out.println(c.evalCrawlScript(conf));
	}

}
