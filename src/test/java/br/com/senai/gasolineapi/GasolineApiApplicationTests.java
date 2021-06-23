package br.com.senai.gasolineapi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.senai.gasolineapi.model.Venda;
import br.com.senai.gasolineapi.repository.VendaRepository;

@SpringBootTest
class GasolineApiApplicationTests {
	@Autowired
	private VendaRepository repo;
	private Venda venda = new Venda();
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void testCalcularTotalVendas() {
		System.out.println("Teste total de vendas");
		assertEquals(715.0, venda.calcularTotalVendas(repo.findAll()));
	}
	
	@Test
	void testCalcularTotalItensVendidos() {
		System.out.println("Teste total de itens vendidos");
		assertEquals(7, venda.calcularTotalItensVendidos(repo.findAll()));
	}
}
