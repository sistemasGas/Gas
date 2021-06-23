package br.com.senai.gasolineapi;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import br.com.senai.gasolineapi.model.Pessoa;
import br.com.senai.gasolineapi.repository.PessoaRepository;
import br.com.senai.gasolineapi.util.PessoaCategoria;
import br.com.senai.gasolineapi.util.TipoPessoa;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class PessoaTest {

	@Autowired
	private PessoaRepository repo;

//	 test de gravação de Pessoa
	@Test
	@Rollback(false)
	public void testCreatePessoa() {
		Pessoa pessoa = new Pessoa(null, "Test", "telefone", "email@email.com", TipoPessoa.FISICA, null, null,
				PessoaCategoria.FUNC, null);
		Pessoa savePesssoa = repo.save(pessoa);

		assertNotNull(savePesssoa);

	}
// test por ID de pessoa
	@Test 
	public void testFindPessoaById() {
		long id = 25;		
		Pessoa pessoa = repo.getOne(id);
		
		assertThat(pessoa.getId()).isEqualTo(id);
	}

}
