package br.loja.repository.models;

public class Produto {
	
	public Produto(int id, String nome, String descricao) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}
	private int id;
	private String nome;
	private String descricao;

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Id: " + this.id + "| Nome: " + this.nome + "| Descrição: " + this.descricao; 
	}

}
