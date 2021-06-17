package br.com.senai.gasolineapi.resource;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.gasolineapi.model.Usuario;
import br.com.senai.gasolineapi.repository.UsuarioRepository;


@RestController
@RequestMapping("/usuarios")
public class UsuarioResources {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping
	public List<Usuario> listar() {
		return  usuarioRepository.findAll();
	}
	@PostMapping
	public void post(@RequestBody Usuario user) {
		usuarioRepository.save(user);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		usuarioRepository.deleteById(id);
	}
	
	@PutMapping 
	public void put(@RequestBody Usuario user) {
		usuarioRepository.save(user);
	}
	@GetMapping("/{login}")
	public ResponseEntity<Optional<Usuario>> buscarPorLogin(@PathVariable String login) {
		List<Usuario> listaLogin =  usuarioRepository.findAll();
		Usuario usuariolog = new Usuario();
			for(Usuario u: listaLogin) {
				if (login.equals(u.getLogin())) usuariolog = u;
			}
			return usuariolog != null ? ResponseEntity.ok(Optional.of(usuariolog)) : ResponseEntity.notFound().build() ;
		
	}

}
