package br.com.senai.gasolineapi.util;

public enum PerfilEnum {
	
	Admin("Administrador"),
	Func("Funcionario");
	
	private String tipoPerfil;
	
	PerfilEnum(String tipoPerfil) {
		this.tipoPerfil = tipoPerfil;
	}
	
	public String getDescricao() { 
		return tipoPerfil;
	}
}
