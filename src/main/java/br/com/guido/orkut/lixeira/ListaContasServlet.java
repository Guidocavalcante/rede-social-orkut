package br.com.guido.orkut.lixeira;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.guido.orkut.modelo.BancoDeDados;
import br.com.guido.orkut.modelo.Conta;

//@WebServlet(name = "listaContas", urlPatterns = { "/listaContas" })
public class ListaContasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		BancoDeDados banco = new BancoDeDados();
		List<Conta> lista = banco.getContas();
		
//		PrintWriter out = response.getWriter();
//		out.println("<html><body>");
//		out.println("<ul>");
//		out.println("Lista de Contas Cadastradas");
//		out.println("<br /><br />");
//		for(Conta conta:lista) {
//			out.println("<br />");
//			out.println("<li>" + "Conta: " + conta.getNome() + "</li>");
//			out.println("<br />");
//			out.println("<li>" + " E-mail: " + conta.getUsuario() + "</li>");
//			out.println("<br />");
//			out.println("<li>" + " Senha: " + conta.getSenha() + "</li>");
//		}
//		out.println("</ul>");
//		out.println("</html></body>");
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/listaContas.jsp");
		request.setAttribute("contas", lista);
		rd.forward(request, response);
	}

}
