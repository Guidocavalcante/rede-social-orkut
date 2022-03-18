package br.com.guido.orkut.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.guido.orkut.modelo.BancoDeDados;
import br.com.guido.orkut.modelo.Conta;

public class AlteraConta implements Acao{

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Alterando conta");
		String nomeCompleto = request.getParameter("nome");
		String nomeUsuario = request.getParameter("email");
		String senha = request.getParameter("senha");
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		String paramDataNascimento = request.getParameter("data");
		Date dataNascimento = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			dataNascimento = sdf.parse(paramDataNascimento);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		
		BancoDeDados banco = new BancoDeDados();
		Conta conta = banco.buscaContaPeloId(id);
		conta.setDataNascimento(dataNascimento);
		conta.setNome(nomeCompleto);
		conta.setSenha(senha);
		conta.setEmail(nomeUsuario);
		
		return "redirect:entrada?acao=ListaContas";
		
	}
	
}
