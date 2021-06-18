package br.com.senai.gasolineapi.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.gasolineapi.model.Pessoa;
import br.com.senai.gasolineapi.repository.PessoaRepository;
import br.com.senai.gasolineapi.util.PessoaCategoria;

@RestController
@RequestMapping("/pessoa")
public class PessoaResource {

	@Autowired
	private PessoaRepository pessoaRespository;

	@GetMapping
	public List<Pessoa> get() {
		return pessoaRespository.findAll();
	}

	@GetMapping("/{id}")
	public Optional<Pessoa> get(@PathVariable("id") Long id) {
		return pessoaRespository.findById(id);
	}

	@PostMapping
	public void post(@RequestBody Pessoa pessoa) {
		pessoaRespository.save(pessoa);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		pessoaRespository.deleteById(id);
	}

	@GetMapping("/qntClientes")
	public int buscaTotalClientes() {
		List<Pessoa> lista = get();

		int qntCliente = 0;
		for (Pessoa p : lista) {
			if (p.getCategoria().equals(PessoaCategoria.CLIENT))
				qntCliente++;
		}
		return qntCliente;
	}
	@GetMapping("/qntFornecedores")
	public int buscaTotalFornecedores() {
		List<Pessoa> lista = get();

		int qntFornecedor = 0;
		for (Pessoa p : lista) {
			if (p.getCategoria().equals(PessoaCategoria.FORN))
				qntFornecedor++;
		}
		return qntFornecedor;
	}
	@GetMapping("/qntClienteFornecedor")
	public int buscaTotalClientesFornecedor() {
		List<Pessoa> lista = get();

		int qntClienteFornecedor = 0;
		for (Pessoa p : lista) {
			if (p.getCategoria().equals(PessoaCategoria.CLIFOR))
				qntClienteFornecedor++;
		}
		return qntClienteFornecedor;
	}
	@GetMapping("/qntFuncionarios")
	public int buscaTotalFuncionarios() {
		List<Pessoa> lista = get();

		int qntFuncionarios = 0;
		for (Pessoa p : lista) {
			if (p.getCategoria().equals(PessoaCategoria.FUNC))
				qntFuncionarios++;
		}
		return qntFuncionarios;
	}
	
}
