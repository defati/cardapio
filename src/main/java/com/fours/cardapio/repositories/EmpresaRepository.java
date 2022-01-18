package com.fours.cardapio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fours.cardapio.entities.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long>{
	
	List<Empresa> findEmpresaByNomeContaining(String pesquisa);

}
