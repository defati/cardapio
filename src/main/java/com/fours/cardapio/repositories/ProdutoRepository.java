package com.fours.cardapio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fours.cardapio.entities.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
	List<Produto> findProdutoByNomeContaining(String pesquisa);

}
