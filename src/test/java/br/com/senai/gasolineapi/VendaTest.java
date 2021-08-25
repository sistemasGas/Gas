package br.com.senai.gasolineapi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.senai.gasolineapi.model.ItemVenda;
import br.com.senai.gasolineapi.model.Venda;
import br.com.senai.gasolineapi.repository.VendaRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class VendaTest {
	@Autowired
	private VendaRepository repo;
	private Venda venda = new Venda();
	private ItemVenda item = new ItemVenda();


	@Test
	void testCalcularTotalVendas() {
		System.out.println("Teste total de vendas");
		assertEquals(375.0, venda.calcularTotalVendas(repo.findAll()));
	}

	@Test
	void testCalcularTotalItensVendidos() {
		System.out.println("Teste total de itens vendidos");
		assertEquals(5, venda.calcularTotalItensVendidos(repo.findAll()));
	}
	
	@Test
	void testarTotalItem() {
		System.out.println("Teste total de itens da venda");
		venda = repo.findById((long) 18);
		assetEquals(270, item.getVenda(repo.findById(18))));
	}
}
