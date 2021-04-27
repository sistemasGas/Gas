package br.com.senai.gasolineapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.gasolineapi.model.Venda;


public interface VendaRepository extends JpaRepository<Venda, Long>{

}
