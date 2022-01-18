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

import com.fours.cardapio.entities.Empresa;
import com.fours.cardapio.services.EmpresaService;

@RestController
@RequestMapping("/empresa")
public class EmpresaResource {

	@Autowired
	EmpresaService empresaService;
	
	@PostMapping("/salvar")
	public ResponseEntity<String> salvar(@RequestBody Empresa empresa){
		return empresaService.salva(empresa);
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<Empresa>> listar(){
		return empresaService.lista();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Empresa>> buscarPorId(@PathVariable("id") Long id){
		return empresaService.buscaPorId(id);
	}
	
	@GetMapping("/pesquisar/{pesquisa}")
	public ResponseEntity<List<Empresa>> pesquisar(@PathVariable("pesquisa") String pesquisa){
		return empresaService.pesquisa(pesquisa);
	}
	
	@PutMapping("/editar")
	public ResponseEntity<String> editar(@RequestBody Empresa empresa){
		return empresaService.edita(empresa);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletar(@PathVariable("id") Long id){
		return empresaService.deleta(id);
	}
	
}
