package br.com.senai.gasolineapi.repository;

import br.com.senai.gasolineapi.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository <Endereco, Long>{

}
