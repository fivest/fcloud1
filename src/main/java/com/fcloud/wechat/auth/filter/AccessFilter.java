/**
 * 
 */
package com.fcloud.wechat.auth.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.UrlPathHelper;

import com.fcloud.wechat.auth.model.AuthMatcher;
import com.fcloud.wechat.auth.model.SessionUser;

/**
 * @author ruben
 *
 */
@Component("AccessFilter")
public class AccessFilter extends OncePerRequestFilter implements Filter {
	
	@Autowired
	private AuthMatcher authMatcher;
	
	private UrlPathHelper urlPathHelper = new UrlPathHelper();
	
	private PathMatcher pathMatcher = new AntPathMatcher();
	
	private String loginUrl = "/login";
	
	private String[] ignorePaths = null;

	public String getLoginUrl() {
		return loginUrl;
	}

	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}

	public String[] getIgnorePaths() {
		return ignorePaths;
	}

	public void setIgnorePaths(String[] ignorePaths) {
		this.ignorePaths = ignorePaths;
	}
	
	protected void initBeanWrapper(BeanWrapper bw) throws BeansException {
		bw.registerCustomEditor(String[].class, new StringArrayPropertyEditor(",", null, false, true));
	}
	
	protected void initFilterBean() throws ServletException {
		super.initFilterBean();
		// logger.info("ignorePaths size:" + ignorePaths.length + " ; detail: " + Arrays.asList(ignorePaths));
	}

	private boolean isProtected(String url) {
		for (String pattern : ignorePaths) {
			if (pathMatcher.match(pattern, url)) {
				//logger.info("match ignore path : pattern = " + pattern + ", request url = " + url);
				return false;
			}
		}
		//logger.info("not matched url = " + url);
		return true;
	}
	
	protected void doFilterInternal(
			HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		String url = urlPathHelper.getLookupPathForRequest(request);
		
		if (isProtected(url)) {
			SessionUser user = SessionUser.get();
			if (user == null) {
				response.sendRedirect(request.getContextPath() + loginUrl);
				return;
			}
			if (!user.isAdmin() && authMatcher != null && !authMatcher.accept(url, user)) {
				response.sendRedirect(request.getContextPath() + loginUrl);
				return;
			}
			chain.doFilter(request, response);
		} else {
			chain.doFilter(request, response);
		}
	}

}
