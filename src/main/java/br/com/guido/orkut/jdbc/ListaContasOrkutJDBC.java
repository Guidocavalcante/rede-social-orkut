package br.com.guido.orkut.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ListaContasOrkutJDBC {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactoryOrkut cf = new ConnectionFactoryOrkut();
		Connection con = cf.recuperarConexaoOrkut();
		
		PreparedStatement pstm = con.prepareStatement("SELECT ID, NOME, EMAIL, SENHA FROM CONTA");
		pstm.execute();
		
		ResultSet rst = pstm.getResultSet();
		while(rst.next()) {
			Integer id = rst.getInt("ID");
			System.out.println("ID: " + id);
			String nome = rst.getString("NOME");
			System.out.println("Nome: " + nome);
			String email = rst.getString("EMAIL");
			System.out.println("Email: " + email);
			String senha = rst.getString("SENHA");
			System.out.println("Senha: " + senha);
			
		}
		
		
		
	}

}
