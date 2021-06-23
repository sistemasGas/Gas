package br.com.senai.gasolineapi;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.senai.gasolineapi.model.Pessoa;
import br.com.senai.gasolineapi.repository.PessoaRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class PessoaTest {

	@Autowired
	private PessoaRepository repo;

	@Test
	public void testCreatePessoa() {
		Pessoa pessoa = new Pessoa(null, "Test", "telefone", "email@email.com", null, "FUNC","FISICA", null, null);
//		Pessoa pessoa = new Pessoa("Test", "telefone", "email@email.com", "FUNC","FISICA");
		Pessoa savePesssoa = repo.save(pessoa);
		
		assertNotNull(savePesssoa);

	}
	
//	@Test void testCreateUsuario() {
//		Usuario usuario = new Usuario();
//		repo.saveAll(usuario);
//	}
		
//	public void buscarId() {
//		Long idLogin = (long) 1;
//		Optional<Pessoa> user = repo.findById(idLogin);
//		assertThat(user.get()).isEqualTo(idLogin);
//	}
	
}
