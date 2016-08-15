package com.github.stock_data.common.util;

import org.junit.Test;

public class SecurityUtilTest {

	@Test
	public void test() {
		String pwd = SecurityUtil.getMd5Password("abc");
		System.out.println(pwd+" "+pwd.length());
	}

}
