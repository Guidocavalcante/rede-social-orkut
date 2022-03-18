package br.com.guido.orkut.lixeira;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.guido.orkut.modelo.BancoDeDados;

//@WebServlet  ("/deletaConta")
public class DeletaContaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String paramId = request.getParameter("id");//RECEBENDO O VALOR DO PARÂMETRO 'id' E ATRIBUINDO SEU VALOR Á STRING 'paramId'
	Integer id = Integer.valueOf(paramId);//TRANSFORMANDO STRING EM INTEGER;
	
	BancoDeDados banco = new BancoDeDados();
	banco.deletaConta(id);
	response.sendRedirect("listaContas");
	
	}

}
