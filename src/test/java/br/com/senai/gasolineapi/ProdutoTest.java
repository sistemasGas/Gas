package br.com.senai.gasolineapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.senai.gasolineapi.model.Produto;
import br.com.senai.gasolineapi.repository.ProdutoRepository;

@DataJpaTest
public class ProdutoTest {
	@Autowired
	private ProdutoRepository repo;
	
	@Test
	public void testeCriarProduto() {
		Produto produto = new Produto();
		repo.save(produto);
	}
}
