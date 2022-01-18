package com.fours.cardapio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fours.cardapio.entities.Produto;
import com.fours.cardapio.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository produtoRepository;
	
	public ResponseEntity<String> salva(Produto produto){
		produtoRepository.save(produto);
		return ResponseEntity.status(201).body("Salvo com sucesso");
	}
	
	public ResponseEntity<List<Produto>> lista(){
		return ResponseEntity.ok(produtoRepository.findAll());
	}
	
	public ResponseEntity<Optional<Produto>> buscaPorId(Long id){
		return ResponseEntity.ok(produtoRepository.findById(id));
	}
	
	public ResponseEntity<List<Produto>> pesquisa(String pesquisa){
		return ResponseEntity.ok(produtoRepository.findProdutoByNomeContaining(pesquisa));
	}
	
	public ResponseEntity<String> edita(Produto produto){
		produtoRepository.save(produto);
		return ResponseEntity.status(200).body("Editado com sucesso");
	}
	
	public ResponseEntity<String> deleta(Long id){
		produtoRepository.deleteById(id);
		return ResponseEntity.status(200).body("Deletado com sucesso");
	}
	
}
