package br.com.guido.orkut.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.guido.orkut.modelo.BancoDeDados;
import br.com.guido.orkut.modelo.Conta;

public class LoginUsuario implements Acao{
public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Fazendo login");
		
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		BancoDeDados banco = new BancoDeDados();
		Conta conta = banco.existeConta(email, senha);
		if(conta!=null) {
			System.out.println("Conta existe!");
			HttpSession sessao = request.getSession();
			sessao.setAttribute("contaLogada", conta);
			return "redirect:entrada?acao=ListaContas";
		}else {
			System.out.println("Conta não existe!");
			return "forward:/formLogin.jsp";
		}
		}
}
