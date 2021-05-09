package br.com.senai.gasolineapi.repository.venda;

import java.util.List;

import br.com.senai.gasolineapi.model.Venda;
import br.com.senai.gasolineapi.repository.filter.VendaFilter;

public interface VendaRepositoryQuery {
	public List<Venda> filtrar(VendaFilter vendaFilter);
}
