package br.com.senai.gasolineapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.gasolineapi.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
