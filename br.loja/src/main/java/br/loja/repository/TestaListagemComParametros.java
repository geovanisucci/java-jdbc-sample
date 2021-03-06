package br.loja.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.loja.repository.data.connection.ConnectionFactory;
import br.loja.repository.models.Produto;

public class TestaListagemComParametros {
	
	public static void main(String[] args) {
		
		try {
			
			ConnectionFactory criaConexao = new ConnectionFactory();
			
			Connection connection = criaConexao.recuperarConexao();
			
			PreparedStatement statement = connection.prepareStatement("Select * From produto where id = ?");
			statement.setInt(1, 4);
			//statement.execute();
			
			ResultSet rs = statement.executeQuery();
			//ou
			//ResultSet rs = statement.getResultSet();
			
			List<Produto> produtos = new ArrayList<Produto>();
			
			while (rs.next()) {
				
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String descricao = rs.getString("descricao");
				
				Produto p = new Produto(id, nome, descricao);
				produtos.add(p);				
			}
			
			
			if(!connection.isClosed()) {
				connection.close();
			}
			
			
			for (Produto produto : produtos) {
				
				System.out.println(produto.toString());
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
	}

}
