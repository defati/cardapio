package com.fours.cardapio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fours.cardapio.entities.Consumidor;
import com.fours.cardapio.repositories.ConsumidorRepository;

@Service
public class ConsumidorService {

	@Autowired
	ConsumidorRepository consumidorRepository;
	
	public ResponseEntity<String> salva(Consumidor consumidor){
		consumidorRepository.save(consumidor);
		return ResponseEntity.status(201).body("Salvo com sucesso");
	}
	
	public ResponseEntity<List<Consumidor>> lista(){
		return ResponseEntity.ok(consumidorRepository.findAll());
	}
	
	public ResponseEntity<Optional<Consumidor>> buscaPorId(Long id){
		return ResponseEntity.ok(consumidorRepository.findById(id));
	}
	
	public ResponseEntity<List<Consumidor>> pesquisa(String pesquisa){
		return ResponseEntity.ok(consumidorRepository.findConsumidorByNomeContaining(pesquisa));
	}
	
	public ResponseEntity<String> edita(Consumidor consumidor){
		consumidorRepository.save(consumidor);
		return ResponseEntity.status(200).body("Editado com sucesso");
	}
	
	public ResponseEntity<String> deleta(Long id){
		consumidorRepository.deleteById(id);
		return ResponseEntity.status(200).body("Deletado com sucesso");
	}
	
}
