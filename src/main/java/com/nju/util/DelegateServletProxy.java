package com.nju.util;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class DelegateServletProxy extends GenericServlet {

	/**
	 * DelegateServletProxy功能，采用代理模式，在spring启动后执行初始化操作
	 */
	private static final long serialVersionUID = 1L;
	private String targetBean;
	private Servlet proxy;
	
	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		proxy.service(request, response);

	}
	
	@Override
	public void init() throws ServletException {
		this.targetBean = getServletName();
		getServletBean();
		proxy.init(getServletConfig());
	}

	private void getServletBean(){
		WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		this.proxy = (Servlet)wac.getBean(targetBean);
	}

}
