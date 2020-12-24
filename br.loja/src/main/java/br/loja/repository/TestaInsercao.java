package br.loja.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import br.loja.repository.data.connection.ConnectionFactory;

public class TestaInsercao {
	
	public static void main(String[] args) {
		
		try {
			
			ConnectionFactory connectionFactory = new ConnectionFactory();
			Connection connection = connectionFactory.recuperarConexao();
			
			Statement stm = connection.createStatement();
			
			String sql = "Insert into produto (nome, descricao) values ('Vitamina', 'Vitamina VitDay')";
			
			stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
			
			ResultSet rs = stm.getGeneratedKeys();
			
			while (rs.next()) {
				
				int id = rs.getInt(1);
				
				System.out.println("ID Gerado -> " + id);
				
			}
			
			
			if(!connection.isClosed()) {
				connection.close();
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
