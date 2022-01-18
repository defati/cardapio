package com.fours.cardapio.entities;

public enum Nivel {
	
	Super("SuperAdmin"),
	Adm("Admin"),
	Nv1("Nível 1"),
	Nv2("Nível 2");

	  private final String nome;

	  /**
	   * Construtor do enum
	   *
	   * @param nome    nome da unidade da federação completo
	   * @param sigla   sigla da unidade da federação
	   */
	  Nivel(final String nome) {
		  this.nome = nome;
	  }

		public String getNome() {
			return nome;
		}
	
}