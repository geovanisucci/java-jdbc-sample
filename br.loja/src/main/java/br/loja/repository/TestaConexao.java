package br.loja.repository;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestaConexao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC", "root", "developer");
			
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
