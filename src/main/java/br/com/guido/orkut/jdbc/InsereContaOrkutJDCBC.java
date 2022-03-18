package br.com.guido.orkut.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsereContaOrkutJDCBC {

	public static void main(String[] args) throws SQLException {
		ConnectionFactoryOrkut cf = new ConnectionFactoryOrkut();
		try (Connection con = cf.recuperarConexaoOrkut();) {

			con.setAutoCommit(false);//o false tira a autoriza��o do connection para execu��o da transa��o
//			AGORA A TRANSA��O S� OCORRE COM MINHA AUTORIZA��O: con.commit();
			
			try (PreparedStatement pstm = con.prepareStatement(
					"INSERT INTO CONTA (nome, email, senha) VALUES (?, ? ,? )", Statement.RETURN_GENERATED_KEYS);) {

				adicionaConta("Let�cia Bessa", "leticiaalbuquerque@gmail.com", "123456", pstm);
				adicionaConta("Maria Cristina", "mariacristina@gmail.com", "123456", pstm);
				con.commit();
			} catch(Exception e) {
				e.printStackTrace();
				System.out.println("Executando Rollback");
				con.rollback();
			}
		}
	}

	private static void adicionaConta(String nome, String email, String senha, PreparedStatement pstm)
			throws SQLException {
		pstm.setString(1, nome);
		pstm.setString(2, email);
		pstm.setString(3, senha);
		

		if(nome.equals("Maria Cristina")) {
			throw new RuntimeException("N�o foi poss�vel adicionar o produto");
		}
		pstm.execute();
		try (ResultSet rst = pstm.getGeneratedKeys();) {
			while (rst.next()) {
				Integer id = rst.getInt(1);

				System.out.println("ID 	 foi: " + id);
			}
		}
	}

}
