package br.com.senai.gasolineapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.gasolineapi.model.Compra;

public interface CompraRepository extends JpaRepository<Compra, Long> {

}
