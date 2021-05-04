package br.com.senai.gasolineapi.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.senai.gasolineapi.model.Produto;
import br.com.senai.gasolineapi.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public Produto atualizar(Long id, Produto produto) {
		Produto produtoSalvo = buscarProdutoPorId(id);
		BeanUtils.copyProperties(produto, produtoSalvo, "id");
		return produtoRepository.save(produtoSalvo);

	}

	private Produto buscarProdutoPorId(Long id) {
		Produto produtoSalvo = produtoRepository.getOne(id);
		if (produtoSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return produtoSalvo;
	}

	public void atualizarValor(Long id, Double valorVenda) {
		Produto produtoSalvo = buscarProdutoPorId(id);
		produtoSalvo.setValorVenda(valorVenda);
		produtoRepository.save(produtoSalvo);
	}

	public void atualizarEstoque(Long id, Long quantidadeEstoque) {
		Produto produtoSalvo = buscarProdutoPorId(id);
		produtoSalvo.setQuantidadeEstoque(quantidadeEstoque);
		produtoRepository.save(produtoSalvo);
	}
	
}
