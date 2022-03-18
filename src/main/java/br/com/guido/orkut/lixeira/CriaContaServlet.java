package br.com.guido.orkut.lixeira;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.guido.orkut.modelo.BancoDeDados;
import br.com.guido.orkut.modelo.Conta;

/**
 * Servlet implementation class CriaConta
 */
//@WebServlet("/criaConta")
public class CriaContaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	System.out.println("Cadastrando Conta Nova");
	String nomeCompleto = request.getParameter("nome");
	
	String nomeUsuario = request.getParameter("email");
	String senha = request.getParameter("senha");
	
	String paramDataNascimento = request.getParameter("data");
	Date dataNascimento = null;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	try {
		dataNascimento = sdf.parse(paramDataNascimento);
	} catch (ParseException e) {
		e.printStackTrace();
	}
	
	
	Conta conta = new Conta();
	conta.setNome(nomeCompleto);
	conta.setEmail(nomeUsuario);
	conta.setSenha(senha);
	//conta.setDataNascimento(paramDataNascimento); não compila pois 'setDataNascimento' é do tipod 'Date'
	conta.setDataNascimento(dataNascimento);
	
	BancoDeDados banco = new BancoDeDados();
	banco.adiciona(conta);
	
	
//	PrintWriter out = response.getWriter();
//	out.println("<html><body>Conta Cadastrada!<html><body>");
	request.setAttribute("conta", conta.getNome());
	response.sendRedirect("listaContas");
	
//	RequestDispatcher rd = request.getRequestDispatcher("/listaContas");
//	request.setAttribute("senha", conta.getSenha());
	
//	request.setAttribute("email", conta.getUsuario());
//	rd.forward(request, response);
	}

}
