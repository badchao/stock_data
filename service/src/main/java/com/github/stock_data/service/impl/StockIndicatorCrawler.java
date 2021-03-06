package com.github.stock_data.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.security.cert.X509Certificate;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.util.Assert;

import com.github.rapid.common.util.DateConvertUtil;
import com.github.rapid.common.util.ScriptEngineUtil;
import com.github.rapid.common.util.SelectorUtil;
import com.github.stock_data.common.util.DateUtil;
import com.github.stock_data.common.util.PlainMapUtil;
import com.github.stock_data.cron_job.StockIndicatorCrawlJob;
import com.github.stock_data.model.StockIndicatorConfig;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class StockIndicatorCrawler {

	private static Logger logger = LoggerFactory.getLogger(StockIndicatorCrawler.class);
	
	private static ObjectMapper objectMapper = new ObjectMapper();
	
	public Object evalCrawlScript(StockIndicatorConfig config) throws Exception {
		Assert.hasText(config.getCrawlUrl(),"crawlUrl must be not empty");
		Assert.hasText(config.getCrawlScript(),"crawlScript must be not empty");
		
		String crawlScript = config.getCrawlScript();
		String crawlUrl = config.getCrawlUrl();
		return evalCrawlScript(crawlUrl, crawlScript);
	}

	public Object evalCrawlScript(String crawlUrl, String crawlScript) throws MalformedURLException, Exception {
		String processedCrawlUrl = processUrlByFreemarker(crawlUrl);
		logger.info("evalCrawlScript() processedCrawlUrl:"+processedCrawlUrl); 
		
		String content = readContentByURL(processedCrawlUrl);
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

	private int timeout = 1000 * 60;
	private String readContentByURL(String strUrl) throws MalformedURLException, IOException {
		URL url = new URL(strUrl);
		URLConnection conn = url.openConnection();
		conn.setReadTimeout(timeout);
		conn.setConnectTimeout(timeout);
		conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36");
		InputStream inputStream = null;
		try {
			conn.connect();
			inputStream = conn.getInputStream();
			String content = IOUtils.toString(inputStream);
			return content;
		}finally {
			IOUtils.closeQuietly(inputStream);
		}
	}
	
	
	static {
	    disableSslVerification();
	}

	private static void disableSslVerification() {
		try {
			// Create a trust manager that does not validate certificate chains
			TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
				public java.security.cert.X509Certificate[] getAcceptedIssuers() {
					return null;
				}

				public void checkClientTrusted(X509Certificate[] certs,
						String authType) {
				}

				public void checkServerTrusted(X509Certificate[] certs,
						String authType) {
				}

				@Override
				public void checkClientTrusted(
						java.security.cert.X509Certificate[] arg0, String arg1)throws CertificateException {
				}

				@Override
				public void checkServerTrusted(
						java.security.cert.X509Certificate[] arg0, String arg1)
						throws CertificateException {
					// TODO Auto-generated method stub
					
				}
			} };

			// Install the all-trusting trust manager
			SSLContext sc = SSLContext.getInstance("SSL");
			sc.init(null, trustAllCerts, new java.security.SecureRandom());
			HttpsURLConnection
					.setDefaultSSLSocketFactory(sc.getSocketFactory());

			// Create all-trusting host name verifier
			HostnameVerifier allHostsValid = new HostnameVerifier() {
				public boolean verify(String hostname, SSLSession session) {
					return true;
				}
			};

			// Install the all-trusting host verifier
			HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (KeyManagementException e) {
			e.printStackTrace();
		}
	}
}
