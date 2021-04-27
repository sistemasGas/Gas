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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.senai.gasolineapi.model.Compra;
import br.com.senai.gasolineapi.repository.CompraRepository;
import br.com.senai.gasolineapi.service.CompraService;

@RestController
@RequestMapping("/compras")
public class CompraResource {
	
	@Autowired
	private CompraRepository compraRepository;
	
	@Autowired
	private CompraService compraService;
	
	
	@GetMapping
	public List<Compra> pesquisar() {
		return compraRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Compra> criar(@Valid @RequestBody Compra compra, HttpServletResponse response) {
		Compra compraSalva = compraRepository.save(compra);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}").buildAndExpand(compraSalva.getCodigo())
				.toUri();
		response.setHeader("location", uri.toASCIIString());

		return ResponseEntity.created(uri).body(compraSalva);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Optional<Compra>> buscarPorId(@PathVariable Long codigo) {
		Optional<Compra> compra = compraRepository.findById(codigo);
		return compra != null ? ResponseEntity.ok(compra) : ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long codigo) {
		compraRepository.deleteById(codigo);
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Compra> atualizar(@PathVariable Long codigo, @Valid @RequestBody Compra compra) {
		Compra compraSalva = compraService.atualizar(codigo, compra);
		return ResponseEntity.ok(compraSalva);
	}

}
