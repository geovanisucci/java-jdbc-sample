package br.loja.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.xdevapi.PreparableStatement;

import br.loja.repository.data.connection.ConnectionFactory;

public class TestaInsercaoComParametro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ConnectionFactory connectionFactory = new ConnectionFactory();
			Connection connection = connectionFactory.recuperarConexao();
			String sql = "Insert into produto (nome, descricao) values (?, ?)";
			PreparedStatement stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			try {
				
				connection.setAutoCommit(false);
				
				adiciona("Teste", "Teste", connection, stm);
				adiciona("Teste 2", "Teste 2", connection, stm);
				
				connection.commit();
				
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				connection.rollback();
			}
			finally {
				
				stm.close();
				if(!connection.isClosed()) {
					connection.close();
				}
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		

	}

	private static void adiciona(String nome, String descricao, Connection connection, PreparedStatement stm) throws SQLException {
		
		
		
		stm.setString(1, nome);
		stm.setString(2, descricao);
		
		stm.execute();
		
		
		ResultSet rs = stm.getGeneratedKeys();
		
		while (rs.next()) {
			
			int id = rs.getInt(1);
			
			System.out.println("ID Gerado -> " + id);
			
		}
		
		
		
		
		
	}

}
