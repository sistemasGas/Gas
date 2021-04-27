package br.com.senai.gasolineapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.gasolineapi.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
 