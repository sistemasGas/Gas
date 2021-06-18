package br.com.senai.gasolineapi.util;

public enum PessoaCategoria {
	
	CLIENT("Cliente"),
	FORN("Fornecedor"),
	FUNC("Funcionário");
	
	private String descricao;
	
	PessoaCategoria(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() { 
		return descricao;
	}
}
