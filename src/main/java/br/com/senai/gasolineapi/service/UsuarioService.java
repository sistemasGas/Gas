package br.com.senai.gasolineapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.senai.gasolineapi.model.Usuario;
import br.com.senai.gasolineapi.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;


	private Usuario buscarUsuarioPorLogin(String login) {
		Usuario usuarioSalvo = usuarioRepository.getOne(null);
		if (usuarioSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return usuarioSalvo;
	}	
}