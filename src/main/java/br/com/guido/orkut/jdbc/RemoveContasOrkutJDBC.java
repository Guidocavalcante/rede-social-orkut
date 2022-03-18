package br.com.guido.orkut.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RemoveContasOrkutJDBC {

	public static void main(String[] args) throws SQLException {

		ConnectionFactoryOrkut cf = new ConnectionFactoryOrkut();
		Connection con = cf.recuperarConexaoOrkut();
		
		PreparedStatement stm = con.prepareStatement("DELETE FROM CONTA WHERE ID>1" );
		
		stm.execute();
		Integer linhasModificadas = stm.getUpdateCount();
		
		System.out.println("Total de linha modificadas: " + linhasModificadas);
		
	}

}
