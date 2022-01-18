package com.fours.cardapio.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fours.cardapio.entities.Consumidor;
import com.fours.cardapio.services.ConsumidorService;

@RestController
@RequestMapping("/consumidor")
public class ConsumidorResource {

	@Autowired
	ConsumidorService consumidorService;
	
	@PostMapping("/salvar")
	public ResponseEntity<String> salvar(@RequestBody Consumidor consumidor){
		return consumidorService.salva(consumidor);
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<Consumidor>> listar(){
		return consumidorService.lista();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Consumidor>> buscarPorId(@PathVariable("id") Long id){
		return consumidorService.buscaPorId(id);
	}
	
	@GetMapping("/pesquisar/{pesquisa}")
	public ResponseEntity<List<Consumidor>> pesquisar(@PathVariable("pesquisa") String pesquisa){
		return consumidorService.pesquisa(pesquisa);
	}
	
	@PutMapping("/editar")
	public ResponseEntity<String> editar(@RequestBody Consumidor consumidor){
		return consumidorService.edita(consumidor);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletar(@PathVariable("id") Long id){
		return consumidorService.deleta(id);
	}
	
}
