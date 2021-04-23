package br.com.senai.gasonline.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.gasonline.demo.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
 