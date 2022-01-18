package com.fours.cardapio.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING) 
	private Nivel nivel;
	  
	@ManyToOne
	@JoinColumn(name = "empresa_id")
	private Empresa empresa; 
	
	//@Temporal(TemporalType.DATE)
	@JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyyy") //data para listar
	private LocalDate dtCadastro;
	
	private String nome;
	private String login;
	private String senha;
	private String email;
	private String fone1;
	private String fone2;
	private String img;
	private String obs;
	private Boolean status;
}
