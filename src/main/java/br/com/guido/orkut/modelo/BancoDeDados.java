package br.com.guido.orkut.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BancoDeDados {

	private static List<Conta> lista = new ArrayList<>();
	private static Integer numeroDeAcesso = 1;
		
	static {
		Conta conta = new Conta();
		conta.setNome("Guido");
		conta.setEmail("guidogcs@gmail.com");
		conta.setSenha("123456");
		conta.setId(numeroDeAcesso++);
		lista.add(conta);
		Conta conta2 = new Conta();
		conta2.setNome("Letícia");
		conta2.setEmail("leticiaalbuquerque@gmail.com");
		conta2.setSenha("123456789");
		conta2.setId(numeroDeAcesso++);
		lista.add(conta2);
	}
	
	public List<Conta> getContas(){
		return BancoDeDados.lista;
	}


	public void adiciona(Conta conta) {
		conta.setId(BancoDeDados.numeroDeAcesso++);
		BancoDeDados.lista.add(conta);
	}


	public void deletaConta(Integer id) {
		Iterator<Conta> it = lista.iterator();//INVOCANDO MÉTODO DO OBJETO ITERATOR PARA PERCORRER A LISTA
		
		while(it.hasNext()) {
			Conta c = it.next();
			if(c.getId()==id) {
				it.remove();
			}
		}
	}


	public Conta buscaContaPeloId(Integer id) {
		for (Conta conta : lista) {
			if(conta.getId()==id) {
				return conta;
			}
		}
		return null;
	}
	
	public Conta existeConta(String email, String senha) {
		for (Conta conta : lista) {
			if(conta.EhIgualConta(email, senha)) {
				return conta;
			} 
		}
		return null;
	}
	
	
	
}
