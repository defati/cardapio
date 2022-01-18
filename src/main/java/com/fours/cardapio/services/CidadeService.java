package com.fours.cardapio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fours.cardapio.entities.Cidade;
import com.fours.cardapio.repositories.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	CidadeRepository cidadeRepository;
	
	public ResponseEntity<String> salva(Cidade cidade){
		cidadeRepository.save(cidade);
		return ResponseEntity.status(201).body("Salvo com sucesso");
	}
	
	public ResponseEntity<List<Cidade>> lista(){
		return ResponseEntity.ok(cidadeRepository.findAll());
	}
	
	public ResponseEntity<Optional<Cidade>> buscaPorId(Long id){
		return ResponseEntity.ok(cidadeRepository.findById(id));
	}
	
	public ResponseEntity<List<Cidade>> pesquisa(String pesquisa){
		return ResponseEntity.ok(cidadeRepository.findCidadeByNomeContaining(pesquisa));
	}
	
	public ResponseEntity<String> edita(Cidade cidade){
		cidadeRepository.save(cidade);
		return ResponseEntity.status(200).body("Editado com sucesso");
	}
	
	public ResponseEntity<String> deleta(Long id){
		cidadeRepository.deleteById(id);
		return ResponseEntity.status(200).body("Deletado com sucesso");
	}
	
}
