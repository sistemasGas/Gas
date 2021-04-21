package br.com.senai.gasolineapi.util;

public enum StatusEnum {

	ORCAMENTO("Orçamento"),
	EMITIDA("Emitida"),
	FINALIZADA("Finalizada"),
	CANCELADA("Cancelada");
	
	private String descricao;
	
	StatusEnum(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
