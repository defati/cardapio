package com.fours.cardapio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fours.cardapio.entities.Empresa;
import com.fours.cardapio.repositories.EmpresaRepository;

@Service
public class EmpresaService {

	@Autowired
	EmpresaRepository empresaRepository;
	
	public ResponseEntity<String> salva(Empresa empresa){
		empresaRepository.save(empresa);
		return ResponseEntity.status(201).body("Salvo com sucesso");
	}
	
	public ResponseEntity<List<Empresa>> lista(){
		return ResponseEntity.ok(empresaRepository.findAll());
	}
	
	public ResponseEntity<Optional<Empresa>> buscaPorId(Long id){
		return ResponseEntity.ok(empresaRepository.findById(id));
	}
	
	public ResponseEntity<List<Empresa>> pesquisa(String pesquisa){
		return ResponseEntity.ok(empresaRepository.findEmpresaByNomeContaining(pesquisa));
	}
	
	public ResponseEntity<String> edita(Empresa empresa){
		empresaRepository.save(empresa);
		return ResponseEntity.status(200).body("Editado com sucesso");
	}
	
	public ResponseEntity<String> deleta(Long id){
		empresaRepository.deleteById(id);
		return ResponseEntity.status(200).body("Deletado com sucesso");
	}
	
}
