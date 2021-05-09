package br.com.senai.gasolineapi.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.senai.gasolineapi.model.Categoria;
import br.com.senai.gasolineapi.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria atualizar(Long id, Categoria categoria) {
		Categoria categoriaSalva = buscarCategoriaPorId(id);
		BeanUtils.copyProperties(categoria, categoriaSalva, "id");
		return categoriaRepository.save(categoriaSalva);

	}

	private Categoria buscarCategoriaPorId(Long id) {
		Categoria categoriaSalva = categoriaRepository.getOne(id);
		if (categoriaSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return categoriaSalva;
	}
}
