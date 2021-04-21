package br.com.senai.gasolineapi.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.senai.gasolineapi.model.Compra;
import br.com.senai.gasolineapi.repository.CompraRepository;

@Service
public class CompraService {

	@Autowired
	private CompraRepository compraRepository;

	public Compra atualizar(Long codigo, Compra compra) {
		Compra compraSalva = buscarCompraPorId(codigo);
		BeanUtils.copyProperties(compra, compraSalva, "codigo");
		return compraRepository.save(compraSalva);

	}

	private Compra buscarCompraPorId(Long codigo) {
		Compra compraSalva = compraRepository.getOne(codigo);
		if (compraSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return compraSalva;
	}
}
