package br.com.guido.orkut.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet("/entrada")
public class AutorizacaoFilter implements Filter{
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
	@Override
	public void destroy() {}
	@Override
	public void doFilter(ServletRequest requestservlet, ServletResponse responseservlet, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("AutorizacaoFilter");
		HttpServletRequest request = (HttpServletRequest) requestservlet;//CASTING
		HttpServletResponse response = (HttpServletResponse) responseservlet;//CASTING
		HttpSession sessao = request.getSession();
		boolean usuarioNaoEstaLogado = (sessao.getAttribute("contaLogada")==null);//VERIFICANDO SE O USUÁRIO ESTÁ LOGADO
		String paramAcao = request.getParameter("acao");
		boolean ehAcaoProtegida = !(paramAcao.equals("LoginUsuario") || paramAcao.equals("LoginForm"));//VERIFICANDO SE É UMA AÇÃO PROTEGIDA   
		if(usuarioNaoEstaLogado && ehAcaoProtegida) {
			response.sendRedirect("entrada?acao=LoginForm");//SE TRUE RETORNA PARA O FORMULÁRIO DE LOGIN
			return;
		}
		else{chain.doFilter(request, response);//SE FALSO, CONTINUA A APLICAÇÃO
	}
	}
	
	
}
