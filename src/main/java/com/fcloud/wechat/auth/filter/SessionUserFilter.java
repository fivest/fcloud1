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
import javax.servlet.http.HttpSession;

import org.springframework.web.filter.OncePerRequestFilter;

import com.fcloud.wechat.auth.model.SessionUser;

/**
 * @author ruben
 *
 */
public class SessionUserFilter extends OncePerRequestFilter implements Filter {

	protected void doFilterInternal(
			HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		SessionUser.remove(); // force remove
		HttpSession session = request.getSession(false);
		if (session != null) {
			SessionUser user = (SessionUser) session.getAttribute(SessionUser.SESSION_KEY);
			SessionUser.set(user);
			try {
				chain.doFilter(request, response);
			} finally {
				SessionUser.remove();
			}
			return;
		}
		chain.doFilter(request, response);
	}

}
