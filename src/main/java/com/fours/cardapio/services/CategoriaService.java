package com.fours.cardapio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fours.cardapio.entities.Categoria;
import com.fours.cardapio.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository categoriaRepository;
	
	public ResponseEntity<String> salvaRetornaId(Categoria categoria){
		categoriaRepository.saveAndFlush(categoria);
		return ResponseEntity.status(201).body("Salvo com Sucesso ID");
	}
	
	public ResponseEntity<String> salva(Categoria categoria){
		categoriaRepository.save(categoria);
		return ResponseEntity.status(201).body("Salvo com sucesso");
	}
	
	public ResponseEntity<List<Categoria>> lista(){
		return ResponseEntity.ok(categoriaRepository.findAll());
	}
	
	public ResponseEntity<Optional<Categoria>> buscaPorId(Long id){
		return ResponseEntity.ok(categoriaRepository.findById(id));
	}
	
	public ResponseEntity<List<Categoria>> pesquisa(String pesquisa){
		return ResponseEntity.ok(categoriaRepository.findCategoriaByNomeContaining(pesquisa));
	}
	
	public ResponseEntity<String> edita(Categoria categoria){
		categoriaRepository.save(categoria);
		return ResponseEntity.status(200).body("Editado com sucesso");
	}
	
	public ResponseEntity<String> deleta(Long id){
		categoriaRepository.deleteById(id);
		return ResponseEntity.status(200).body("Deletado com sucesso");
	}
}