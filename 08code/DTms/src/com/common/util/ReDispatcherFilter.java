package com.common.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * struts2 与 servlet 的隔离过滤器
 * 
 * @author Administrator
 * 
 */
public class ReDispatcherFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		String target = request.getRequestURI();
		target = target.lastIndexOf("?") > 0 ? target.substring(target
				.lastIndexOf("/") + 1, target.lastIndexOf("?")
				- target.lastIndexOf("/")) : target.substring(target
				.lastIndexOf("/") + 1);

		System.out.println(target);
		if (this.includes.contains(target)) {
			RequestDispatcher rdsp = request.getRequestDispatcher(target);
			System.out.println("go........servlet......." + rdsp);
			rdsp.forward(req, resp);
		} else
			System.out.println("go......action........." + resp);
		chain.doFilter(req, resp);
	}

	private ArrayList<String> includes = new ArrayList<String>();

	public void init(FilterConfig config) throws ServletException {
		this.includes.addAll(Arrays.asList(config.getInitParameter(
				"includeServlets").split(",")));

	}

}
