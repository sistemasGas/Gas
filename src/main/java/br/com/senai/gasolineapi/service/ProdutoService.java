package br.com.senai.gasolineapi.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.senai.gasolineapi.model.Produto;
import br.com.senai.gasolineapi.repository.ProdutoRepository;
import br.com.senai.gasolineapi.util.CategoriaEnum;

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

	public Produto salvar(@Valid Produto produto) {
		List<Produto> produtos = produtoRepository.findAll();
		for (Produto p : produtos) {
			if (produto.getId() == p.getId() && (!produto.getDescricao().equals(p.getDescricao()) ||
					!produto.getCategoria().equals(p.getCategoria()) || produto.getValorCompra()!=p.getValorCompra())){
				throw new DuplicateKeyException("Alteração nao Permitida");
			} else if (produto.getId()==null && produto.getCategoria().getCodigo()==p.getCategoria().getCodigo()) {
				throw new DuplicateKeyException("Produto ja existe");
			}
		}
		return produto;
	}
	
}
