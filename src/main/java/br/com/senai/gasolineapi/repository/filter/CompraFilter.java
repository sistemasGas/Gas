package br.com.senai.gasolineapi.repository.filter;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class CompraFilter {
		
	private String fornecedor;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataCompraDe;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataCompraAte;
	public String getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}
	public LocalDate getDataCompraDe() {
		return dataCompraDe;
	}
	public void setDataCompraDe(LocalDate dataCompraDe) {
		this.dataCompraDe = dataCompraDe;
	}
	public LocalDate getDataCompraAte() {
		return dataCompraAte;
	}
	public void setDataCompraAte(LocalDate dataCompraAte) {
		this.dataCompraAte = dataCompraAte;
	}
	
	
}
