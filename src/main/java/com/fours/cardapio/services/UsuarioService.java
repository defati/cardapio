package com.fours.cardapio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fours.cardapio.entities.Usuario;
import com.fours.cardapio.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public ResponseEntity<String> salva(Usuario usuario){
		usuarioRepository.save(usuario);
		return ResponseEntity.status(200).body("Salvo com sucesso");
	}
	
	public ResponseEntity<String> salvaRetornaId(Usuario usuario){
		usuarioRepository.saveAndFlush(usuario);
		return ResponseEntity.status(201).body("Salvo com Sucesso ID");
	}
	
	public ResponseEntity<List<Usuario>> lista(){
		return ResponseEntity.ok(usuarioRepository.findAll());
	}
	
	public ResponseEntity<Optional<Usuario>> buscaPorId(Long id){
		return ResponseEntity.ok(usuarioRepository.findById(id));
	}
	
	public ResponseEntity<List<Usuario>> pesquisa(String pesquisa){
		return ResponseEntity.ok(usuarioRepository.findUsuarioByNomeContaining(pesquisa));
	}
	
	public ResponseEntity<String> edita(Usuario usuario){
		usuarioRepository.save(usuario);
		return ResponseEntity.status(200).body("Editado com sucesso");
	}
	
	public ResponseEntity<String> deleta(Long id){
		usuarioRepository.deleteById(id);
		return ResponseEntity.status(200).body("Deletado com sucesso");
	}
	
}