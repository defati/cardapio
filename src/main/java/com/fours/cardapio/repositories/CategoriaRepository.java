package com.fours.cardapio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fours.cardapio.entities.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	
	List<Categoria> findCategoriaByNomeContaining(String pesquisa);
	
}
