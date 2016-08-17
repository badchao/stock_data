package com.github.stock_data.common.web.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.Assert;
import org.springframework.web.filter.OncePerRequestFilter;

import com.github.stock_data.common.web.util.LoginUtil;

public class SecurityFilter extends OncePerRequestFilter {

	private static Logger log = LoggerFactory.getLogger(SecurityFilter.class);
	
	List<String> skipPaths = new ArrayList<String>(3);

	private String loginUrl = null;
	
	@Override
	protected void initFilterBean() throws ServletException {
		super.initFilterBean();
		String skipStr = getFilterConfig().getInitParameter("skip");
		skipPaths = getSkips(skipStr);
		String loginUrl = getFilterConfig().getInitParameter("loginUrl");
		Assert.hasText(loginUrl,"loginUrl must be not blank");
		this.loginUrl = loginUrl;
		skipPaths.add(loginUrl);
	}

	private List<String> getSkips(String skip) {
		List<String> skipList = new ArrayList<String>();
		if (skip != null) {
			String[] skips = skip.split(",");
			for (int i = 0; i < skips.length; i++) {
				skipList.add(skips[i].trim());
			}
		}
		return skipList;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		String path = request.getRequestURI();

		if (path == null) {
			path = request.getServletPath();
		}
		
		log.info("do login filter,path="+path+" isSkipPath:"+isSkipPath(path)+" skipPaths:"+skipPaths+" loginUrl:"+loginUrl);
		if (path == null) {
			response.sendRedirect("/");
			return;
		}
		
		if(isSkipPath(path)){
			chain.doFilter(request, response);
			return;
		}
		
		if(LoginUtil.hasLoginUser(request)) {
			log.info("has login user,do filter");
			chain.doFilter(request, response);
		}else {
			response.sendRedirect(loginUrl);
		}
	}
	
	
	boolean isSkipPath(String path) {
		path = path.replace('\\', '/');
		AntPathMatcher matcher = new AntPathMatcher();
		for(String skip : skipPaths) {
			if(matcher.match(skip, path) || matcher.match(skip, "/"+path)) {
				return true;
			}
		}
		return false;
	}

}
