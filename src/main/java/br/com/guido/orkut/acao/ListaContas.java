package br.com.guido.orkut.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.guido.orkut.modelo.BancoDeDados;
import br.com.guido.orkut.modelo.Conta;

public class ListaContas  implements Acao{

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	BancoDeDados banco = new BancoDeDados();
	List<Conta> lista = banco.getContas();
	
	request.setAttribute("contas", lista);
	
	return "forward:listaContas.jsp";

}
}	

