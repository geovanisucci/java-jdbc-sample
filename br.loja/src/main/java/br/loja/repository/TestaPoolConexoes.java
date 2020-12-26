package br.loja.repository;

import br.loja.repository.data.connection.ConnectionFactory;

public class TestaPoolConexoes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		
		for (int i = 0; i < 50; i++) {
			
			try {
				
				connectionFactory.recuperarConexao();
				System.out.println("[CONEXÃO NUMERO] --> " + i);
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}

	}

}
