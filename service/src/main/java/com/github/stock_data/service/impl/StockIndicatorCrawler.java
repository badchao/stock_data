package com.github.stock_data.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.util.Assert;

import com.github.rapid.common.util.DateConvertUtil;
import com.github.rapid.common.util.ScriptEngineUtil;
import com.github.rapid.common.util.SelectorUtil;
import com.github.stock_data.common.util.DateUtil;
import com.github.stock_data.common.util.PlainMapUtil;
import com.github.stock_data.model.StockIndicatorConfig;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class StockIndicatorCrawler {

	private static ObjectMapper objectMapper = new ObjectMapper();
	
	public Object evalCrawlScript(StockIndicatorConfig config) throws Exception {
		Assert.hasText(config.getCrawlUrl(),"crawlUrl must be not empty");
		Assert.hasText(config.getCrawlScript(),"crawlScript must be not empty");
		
		String crawlScript = config.getCrawlScript();
		String crawlUrl = config.getCrawlUrl();
		return evalCrawlScript(crawlUrl, crawlScript);
	}

	public Object evalCrawlScript(String crawlUrl, String crawlScript) throws MalformedURLException, Exception {
		String content = readContentByURL(processUrlByFreemarker(crawlUrl));
		Map context = buildContext(content);
		Object result = ScriptEngineUtil.eval("groovy", crawlScript,context);
		Object finalResult = processResult(result);
		if(isBlank(finalResult)) {
			throw new RuntimeException("result is blank,by crawlUrl:"+crawlUrl+" crawlScript:"+crawlScript);
		}
		return finalResult;
	}

	private Map buildContext(String content) {
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
		return context;
	}

	private String processUrlByFreemarker(String crawlUrl) throws Exception {
		Configuration conf = new Configuration();
		Template tmpl = new Template("url",crawlUrl,conf);
		Map model = new HashMap();
		model.put("day", DateConvertUtil.format(new Date(),"yyyy-MM-dd"));
		model.put("DateUtil", new DateUtil());
		model.put("DateUtils", new DateUtils());
		
		return FreeMarkerTemplateUtils.processTemplateIntoString(tmpl, model);
	}

	private Object processResult(Object result) {
		if(result == null) return null;
		
		if(result instanceof Elements) {
			Elements elms = (Elements)result;
			Element first = elms.first();
			if(first == null) return null;
			return first.text();
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
		try {
			String content = IOUtils.toString(inputStream);
			return content;
		}finally {
			IOUtils.closeQuietly(inputStream);
		}
	}
	
}
