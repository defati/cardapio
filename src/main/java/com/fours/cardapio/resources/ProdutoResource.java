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

import com.fours.cardapio.entities.Produto;
import com.fours.cardapio.services.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoResource {

	@Autowired
	ProdutoService produtoService;
	
	@PostMapping("/salvar")
	public ResponseEntity<String> salvar(@RequestBody Produto produto){
		return produtoService.salva(produto);
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<Produto>> listar(){
		return produtoService.lista();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Produto>> buscarPorId(@PathVariable("id") Long id){
		return produtoService.buscaPorId(id);
	}
	
	@GetMapping("/pesquisar/{pesquisa}")
	public ResponseEntity<List<Produto>> pesquisar(@PathVariable("pesquisa") String pesquisa){
		return produtoService.pesquisa(pesquisa);
	}
	
	@PutMapping("/editar")
	public ResponseEntity<String> editar(@RequestBody Produto produto){
		return produtoService.edita(produto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletar(@PathVariable("id") Long id){
		return produtoService.deleta(id);
	}
	
}
