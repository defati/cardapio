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

import com.fours.cardapio.entities.Cidade;
import com.fours.cardapio.services.CidadeService;

@RestController
@RequestMapping("/cidade")
public class CidadeResource {

	@Autowired
	CidadeService cidadeService;
	
	@PostMapping("/salvar")
	public ResponseEntity<String> salvar(@RequestBody Cidade cidade){
		return cidadeService.salva(cidade);
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<Cidade>> listar(){
		return cidadeService.lista();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Cidade>> buscarPorId(@PathVariable("id") Long id){
		return cidadeService.buscaPorId(id);
	}
	
	@GetMapping("/pesquisar/{pesquisa}")
	public ResponseEntity<List<Cidade>> pesquisar(@PathVariable("pesquisa") String pesquisa){
		return cidadeService.pesquisa(pesquisa);
	}
	
	@PutMapping("/editar")
	public ResponseEntity<String> editar(@RequestBody Cidade cidade){
		return cidadeService.edita(cidade);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletar(@PathVariable("id") Long id){
		return cidadeService.deleta(id);
	}
	
}
