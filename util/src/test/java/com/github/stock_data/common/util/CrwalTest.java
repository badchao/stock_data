package com.github.stock_data.common.util;

import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;

import com.github.rapid.common.util.MapUtil;

public class CrwalTest {

	@Test
	public void test() throws Exception {
		URL url = new URL("https://www.yirendai.com/home/index");
		URLConnection conn = url.openConnection();
		conn.setRequestProperty("Accept","application/json, text/javascript, */*; q=0.01");
		
		String string = IOUtils.toString(conn.getInputStream());
		System.out.println("contentType:"+conn.getContentType());
		System.out.println("contentLength:"+conn.getContentLength());
		Map headers = conn.getHeaderFields();
		for(Object key : headers.keySet()) {
			System.out.println(key+"="+headers.get(key));
		}
		
		ObjectMapper objectMapper = new ObjectMapper();
		Map map = objectMapper.readValue(string, Map.class);
		System.out.println(map);
		System.out.println(map.get("dataBroadcast"));
		
//		Document doc = Jsoup.parse(new URL("https://www.yirendai.com/home/index"), 1000 * 10);
//		Elements elms = doc.select(".monthNote");
//		Elements finalVal = elms.select(".monthListIcon1 font");
//		System.out.println(elms);
//		System.out.println(finalVal);
//		System.out.println(finalVal.first().text());
	}
	
}
