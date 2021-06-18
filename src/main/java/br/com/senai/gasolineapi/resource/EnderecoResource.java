package br.com.senai.gasolineapi.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.gasolineapi.model.Endereco;
import br.com.senai.gasolineapi.repository.EnderecoRepository;

@RestController
@RequestMapping("/endereco")
public class EnderecoResource {

	
	@Autowired
	private EnderecoRepository enderecoRespository;
	
	@GetMapping
	public List<Endereco> get() {
		return enderecoRespository.findAll();
	}
	
	@PostMapping
	public void post(@RequestBody Endereco endereco) {
		enderecoRespository.save(endereco);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		enderecoRespository.deleteById(id);
	}
	
}
