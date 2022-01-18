package com.fours.cardapio.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
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
public class Empresa implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "cidade_id")
	private Cidade cidade;
	
	
	//@Temporal(TemporalType.DATE)
	@JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyyy") //data para listar e gravar no DB
	private LocalDate dtCadastro;
	
	private String nome;
	private String endereco;
	private String bairro;
	private String cpfCnpj;
	private String fone1;
	private String fone2;
	private String email;
	private String img;
	private String obs;
	private Boolean status;
}