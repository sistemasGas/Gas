package br.com.gas.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gas.dao.PessoaDao;
import br.com.gas.entidade.Pessoa;

@RestController
@RequestMapping("/pessoa")
public class PessoaRest {

	@Autowired
	private PessoaDao pessoaDao;

	@GetMapping
	public List<Pessoa> get() {
		return pessoaDao.findAll();
	}

	@PostMapping
	public void post(@RequestBody Pessoa pessoa) {
		pessoaDao.save(pessoa);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		pessoaDao.deleteById(id);
	}

}
