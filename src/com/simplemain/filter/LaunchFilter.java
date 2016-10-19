package com.simplemain.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.logicalcobwebs.proxool.ProxoolFacade;
import org.logicalcobwebs.proxool.configuration.PropertyConfigurator;

public class LaunchFilter implements Filter
{

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException
	{
		chain.doFilter(req, res);
	}

	public void init(FilterConfig arg0) throws ServletException
	{
		try
		{
			PropertyConfigurator.configure(System.getProperty("user.dir") + "/conf/db");
		}
		catch (Throwable e)
		{
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

	public void destroy()
	{
		ProxoolFacade.shutdown(1);
	}
}
