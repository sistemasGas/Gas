package br.com.senai.gasolineapi.repository.produto;

import java.util.List;

import br.com.senai.gasolineapi.model.Produto;
import br.com.senai.gasolineapi.repository.filter.ProdutoFilter;

public interface ProdutoRepositoryQuery {
	public List<Produto> filtrar(ProdutoFilter produtoFilter);
}
