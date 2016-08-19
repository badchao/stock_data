package com.github.stock_data.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.util.Assert;

import com.github.rapid.common.util.ScriptEngineUtil;
import com.github.rapid.common.util.SelectorUtil;
import com.github.stock_data.common.util.PlainMapUtil;
import com.github.stock_data.model.StockIndicatorConfig;

public class StockIndicatorCrawler {

	private static ObjectMapper objectMapper = new ObjectMapper();
	
	public Object evalCrawlScript(StockIndicatorConfig config) throws Exception {
		Assert.hasText(config.getCrawlUrl(),"crawlUrl must be not empty");
		Assert.hasText(config.getCrawlScript(),"crawlScript must be not empty");
		
		String crawlScript = config.getCrawlScript();
		String crawlUrl = config.getCrawlUrl();
		return evalCrawlScript(crawlUrl, crawlScript);
	}

	public Object evalCrawlScript(String crawlUrl, String crawlScript) throws MalformedURLException, IOException {
		String content = readContentByURL(crawlUrl);
		Map context = new HashMap();
		context.put("$", new SelectorUtil());
		context.put("_", new SelectorUtil());
		try {
			Object json = objectMapper.readValue(content, Object.class);
			context.put("json", json);
			if(json instanceof Map) {
				Map plainJson = PlainMapUtil.toPlainMap((Map)json);
				context.put("plainJson", plainJson);
			}
		}catch(Exception e) {
			Document doc = Jsoup.parse(content);
			context.put("doc", doc);
		}
		Object result = ScriptEngineUtil.eval("groovy", crawlScript,context);
		if(isBlank(result)) {
			throw new RuntimeException("result is blank,by crawlUrl:"+crawlUrl+" crawlScript:"+crawlScript);
		}
		return result;
	}

	private boolean isBlank(Object result) {
		if(result == null) {
			return true;
		}
		String str = result.toString();
		if(StringUtils.isBlank(str)) {
			return true;
		}
		return false;
	}

	private String readContentByURL(String strUrl) throws MalformedURLException, IOException {
		URL url = new URL(strUrl);
		InputStream inputStream = url.openStream();
		String content = IOUtils.toString(inputStream);
		IOUtils.closeQuietly(inputStream);
		return content;
	}
	
}
