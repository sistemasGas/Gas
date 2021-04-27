package br.com.senai.gasolineapi.repository.filter;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class VendaFilter {
	
	private String cliente;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataVendaDe;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataVendaAte;
	public String getFornecedor() {
		return cliente;
	}
	public void setFornecedor(String cliente) {
		this.cliente = cliente;
	}
	public LocalDate getDataVendaDe() {
		return dataVendaDe;
	}
	public void setDataVendaDe(LocalDate dataVendaDe) {
		this.dataVendaDe = dataVendaDe;
	}
	public LocalDate getDataVendaAte() {
		return dataVendaAte;
	}
	public void setDataVendaAte(LocalDate dataVendaAte) {
		this.dataVendaAte = dataVendaAte;
	}
}
