package br.com.senai.gasolineapi;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import br.com.senai.gasolineapi.model.Usuario;
import br.com.senai.gasolineapi.repository.UsuarioRepository;
import br.com.senai.gasolineapi.util.PerfilEnum;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class UsuarioTest {
	@Autowired
	private UsuarioRepository repo;
	
	@Test
	@Rollback(false)
	private void testSalvarUsuario() {
		Usuario user = new Usuario (null, "321.123.321-12", "max123", PerfilEnum.Func);
		Usuario salvaUser = repo.save(user);
		
		assertNotNull(salvaUser);
	}
	
	@Test 
	public void testFindUsuarioById() {
		long id = 25;		
		Usuario user = repo.getOne(id);
		
		assertThat(user.getId()).isEqualTo(id);
	}
	
	
	
}

