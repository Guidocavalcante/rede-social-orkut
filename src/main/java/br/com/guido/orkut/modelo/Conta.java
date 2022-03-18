package br.com.guido.orkut.modelo;

import java.util.Date;

public class Conta {
private String nome;
private String email;
private String senha;
private Date dataNascimento = new Date();
private int id;
public String getNome() {
	return nome;
}
public String setNome(String nome) {
	return this.nome = nome;
}
public String getSenha() {
	return senha;
}
public String setSenha(String senha) {
	return this.senha = senha;
}
public Date getDataNascimento() {
	return dataNascimento;
}
public void setDataNascimento(Date dataNascimento) {
	this.dataNascimento = dataNascimento;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public boolean EhIgualConta(String email, String senha) {
	if (!this.email.equals(email)) {
		return false;
	} 
	if (!this.senha.equals(senha)) {
		return false;
	}
	return true;
}
}
