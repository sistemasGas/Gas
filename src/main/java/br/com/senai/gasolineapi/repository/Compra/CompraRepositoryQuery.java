package br.com.senai.gasolineapi.repository.Compra;

import java.util.List;

import br.com.senai.gasolineapi.model.Compra;
import br.com.senai.gasolineapi.repository.filter.CompraFilter;

public interface CompraRepositoryQuery {
	public List<Compra> filtrar(CompraFilter compraFilter);
}
