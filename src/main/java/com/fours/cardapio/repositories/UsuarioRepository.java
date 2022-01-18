package com.fours.cardapio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fours.cardapio.entities.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	List<Usuario> findUsuarioByNomeContaining(String pesquisa);
	
}
