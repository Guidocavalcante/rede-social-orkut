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

public class NovaConta implements Acao{
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Nova conta");
		String nomeCompleto = request.getParameter("nome");
		
		String email = request.getParameter("email");
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
		conta.setEmail(email);
		conta.setSenha(senha);
		conta.setDataNascimento(dataNascimento);
		BancoDeDados banco = new BancoDeDados();
		banco.adiciona(conta);
		request.setAttribute("conta", conta.getNome());
		
		return "redirect:entrada?acao=ListaContas";
		
		}
}
