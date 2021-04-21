package br.com.senai.gasolineapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.gasolineapi.model.Produto;
import br.com.senai.gasolineapi.repository.produto.ProdutoRepositoryQuery;

public interface ProdutoRepository extends JpaRepository<Produto, Long>, ProdutoRepositoryQuery {

}
 	