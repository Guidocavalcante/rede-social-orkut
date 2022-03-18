package br.com.guido.orkut.lixeira;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.guido.orkut.modelo.BancoDeDados;
import br.com.guido.orkut.modelo.Conta;
//@WebServlet("/mostraConta")
public class MostraContaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String paramId = request.getParameter("id");//RECEBENDO O VALOR DO PAR�METRO 'id' E ATRIBUINDO SEU VALOR � STRING 'paramId'
		Integer id = Integer.valueOf(paramId);//TRANSFORMANDO STRING EM INTEGER;
		
		BancoDeDados banco = new BancoDeDados();
		Conta conta = banco.buscaContaPeloId(id);
		
		request.setAttribute("conta", conta);
		RequestDispatcher rd = request.getRequestDispatcher("/formAlteraConta.jsp");
		rd.forward(request, response);
		
		
	}

}
