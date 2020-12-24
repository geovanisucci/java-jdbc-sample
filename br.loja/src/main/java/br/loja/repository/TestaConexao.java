package br.loja.repository;

import java.sql.Connection;
import java.sql.DriverManager;

import br.loja.repository.data.connection.ConnectionFactory;

public class TestaConexao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			ConnectionFactory criaConexao = new ConnectionFactory();
			
			Connection connection = criaConexao.recuperarConexao();
			
			System.out.println("-- getConnection OK --");
			
			if(!connection.isClosed()) {
				connection.close();
				System.out.println("-- Connection CLOSED --");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		

	}

}
