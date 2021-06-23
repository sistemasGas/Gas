package br.com.senai.gasolineapi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.senai.gasolineapi.model.Produto;
import br.com.senai.gasolineapi.repository.ProdutoRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class ProdutoTest {
	@Autowired
	private ProdutoRepository repo;
	private Produto produto = new Produto();
	
	@Test
	void testCalcularTotalEstoque() {
		System.out.println("Teste valor do estoque");
		assertEquals(8850.0, produto.calcularValorEstoque(repo.findAll()));
	}
}
