package br.loja.repository;

import java.sql.Connection;
import java.sql.Statement;

import br.loja.repository.data.connection.ConnectionFactory;

public class TestaRemocao {
	
	public static void main(String[] args) {
		try {
			
			ConnectionFactory connectionFactory = new ConnectionFactory();
			Connection connection = connectionFactory.recuperarConexao();
			
			Statement stm = connection.createStatement();
			
			String sql = "Delete from produto where id > 2";
			
			stm.execute(sql);
			
			int count = stm.getUpdateCount();
			
			if(count > 0) {
				System.out.println("Deleteado.");
			}
			
			
			if(!connection.isClosed()) {
				connection.close();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
