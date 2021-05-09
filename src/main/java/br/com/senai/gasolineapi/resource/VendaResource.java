package br.com.senai.gasolineapi.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.senai.gasolineapi.model.Venda;
import br.com.senai.gasolineapi.repository.VendaRepository;
import br.com.senai.gasolineapi.service.VendaService;

@RestController
@RequestMapping("/vendas")
public class VendaResource {

	@Autowired
	private VendaRepository vendaRepository;
	
	@Autowired
	private VendaService vendaService;
	
	
	@GetMapping
	public List<Venda> pesquisar() {
		return vendaRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Venda> criar(@Valid @RequestBody Venda venda, HttpServletResponse response) {
		Venda vendaSalva = vendaRepository.save(venda);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}").buildAndExpand(vendaSalva.getCodigo())
				.toUri();
		response.setHeader("location", uri.toASCIIString());

		return ResponseEntity.created(uri).body(vendaSalva);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Optional<Venda>> buscarPorId(@PathVariable Long codigo) {
		Optional<Venda> venda = vendaRepository.findById(codigo);
		return venda != null ? ResponseEntity.ok(venda) : ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long codigo) {
		vendaRepository.deleteById(codigo);
	}
}
