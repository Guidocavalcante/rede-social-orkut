package br.com.guido.orkut.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.guido.orkut.modelo.BancoDeDados;
import br.com.guido.orkut.modelo.Conta;

public class MostraConta implements Acao{
public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("Mostrando conta");
	String paramId = request.getParameter("id");//RECEBENDO O VALOR DO PAR�METRO 'id' E ATRIBUINDO SEU VALOR � STRING 'paramId'
	Integer id = Integer.valueOf(paramId);//TRANSFORMANDO STRING EM INTEGER;
	
	BancoDeDados banco = new BancoDeDados();
	Conta conta = banco.buscaContaPeloId(id);
	
	request.setAttribute("conta", conta);
	
	return "forward:formAlteraConta.jsp";
	
}
}
