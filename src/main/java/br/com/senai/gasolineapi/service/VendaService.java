package br.com.senai.gasolineapi.service;

import javax.validation.Valid;

import org.hibernate.TransientPropertyValueException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.TransientDataAccessResourceException;
import org.springframework.stereotype.Service;

import br.com.senai.gasolineapi.model.Venda;
import br.com.senai.gasolineapi.repository.VendaRepository;

@Service
public class VendaService {

	@Autowired
	private VendaRepository vendaRepository;

	public Venda atualizar(Long codigo, Venda venda) {
		Venda vendaSalva = buscarVendaPorId(codigo);
		BeanUtils.copyProperties(venda, vendaSalva, "codigo");
		return vendaRepository.save(vendaSalva);

	}

	private Venda buscarVendaPorId(Long codigo) {
		Venda vendaSalva = vendaRepository.getOne(codigo);
		if (vendaSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return vendaSalva;
	}

	public Venda salvar(@Valid Venda venda) {
		if (venda.getItensVenda().isEmpty()) {
			throw new TransientPropertyValueException("","","","");
		} else {
			return venda;
		}
	}
}
