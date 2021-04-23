package br.com.gas.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gas.entidade.Pessoa;

@Repository
public interface PessoaDao extends JpaRepository<Pessoa, Long>{

}
