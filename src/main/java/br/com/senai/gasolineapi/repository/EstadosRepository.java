package br.com.senai.gasolineapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.gasolineapi.model.Estado;

public interface EstadosRepository extends JpaRepository<Estado, Long>{

}
