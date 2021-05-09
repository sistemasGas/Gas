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

import br.com.senai.gasolineapi.model.Produto;
import br.com.senai.gasolineapi.repository.ProdutoRepository;
import br.com.senai.gasolineapi.repository.filter.ProdutoFilter;
import br.com.senai.gasolineapi.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoResource {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping
	public List<Produto> pesquisar(ProdutoFilter produtoFilter) {
		return produtoRepository.filtrar(produtoFilter);
	}
	

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Produto> criar(@Valid @RequestBody Produto produto, HttpServletResponse response) {
		Produto produtoSalvo = produtoRepository.save(produto);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(produtoSalvo.getId())
				.toUri();
		response.setHeader("location", uri.toASCIIString());

		return ResponseEntity.created(uri).body(produtoSalvo);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Produto>> buscarPorId(@PathVariable Long id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		return produto != null ? ResponseEntity.ok(produto) : ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id) {
		produtoRepository.deleteById(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Produto> atualizar(@PathVariable Long id, @Valid @RequestBody Produto produto) {
		Produto produtoSalvo = produtoService.atualizar(id, produto);
		return ResponseEntity.ok(produtoSalvo);
	}
	
	@PutMapping("/{id}/valor")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizarValor(@PathVariable Long id, @RequestBody Double valorVenda ) {
		produtoService.atualizarValor(id, valorVenda);
	}
	
	@PutMapping("/{id}/estoque")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizarEstoque(@PathVariable Long id, @RequestBody Long quantidadeEstoque ) {
		produtoService.atualizarEstoque(id, quantidadeEstoque);
	}
	
	@GetMapping("/valorestoque")
	public double buscarTotalProdutos( ProdutoFilter produtoFilter) {
		List<Produto> lista = pesquisar(produtoFilter);
		
		double valor=0;
		for(Produto p: lista) {
			valor += p.getValorVenda()*p.getQuantidadeEstoque();
		}
		return valor;
	}
}
