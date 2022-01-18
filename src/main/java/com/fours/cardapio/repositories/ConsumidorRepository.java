package com.fours.cardapio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fours.cardapio.entities.Consumidor;

@Repository
public interface ConsumidorRepository extends JpaRepository<Consumidor, Long>{
	
	List<Consumidor> findConsumidorByNomeContaining(String pesquisa);

}
