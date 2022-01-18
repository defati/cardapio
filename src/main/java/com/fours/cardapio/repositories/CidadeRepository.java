package com.fours.cardapio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fours.cardapio.entities.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long>{
	
	List<Cidade> findCidadeByNomeContaining(String pesquisa);

}
