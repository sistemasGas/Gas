package br.com.senai.gasolineapi.util;

public enum CategoriaEnum {
	
	P2("2 Kg"),
	P5("5 Kg"),
	P13("13 Kg"),
	P20("20 Kg"),
	P45("45 Kg"),
	P90("90 Kg"),
	AGUA("Galão");
	
	private String descricao;
	
	CategoriaEnum(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() { 
		return descricao;
	}
}
