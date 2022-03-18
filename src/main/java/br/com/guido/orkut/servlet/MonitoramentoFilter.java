package br.com.guido.orkut.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MonitoramentoFilter implements Filter{
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
	@Override
	public void destroy() {}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("MonitoramentoFilter");
		long antes = System.currentTimeMillis();
		chain.doFilter(request, response);
		long depois = System.currentTimeMillis();
		String paramAcao = request.getParameter("acao");
		System.out.println("Tempo de Execu��o: " + paramAcao + " -> " + (depois-antes) );
	}

}
