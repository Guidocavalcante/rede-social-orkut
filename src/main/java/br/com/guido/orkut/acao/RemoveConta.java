package br.com.guido.orkut.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.guido.orkut.modelo.BancoDeDados;

public class RemoveConta implements Acao{
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Removendo conta");
		String paramId = request.getParameter("id");//RECEBENDO O VALOR DO PARÂMETRO 'id' E ATRIBUINDO SEU VALOR Á STRING 'paramId'
		Integer id = Integer.valueOf(paramId);//TRANSFORMANDO STRING EM INTEGER;
		
		BancoDeDados banco = new BancoDeDados();
		banco.deletaConta(id);
		
		return "redirect:entrada?acao=ListaContas";
		
		}
}
