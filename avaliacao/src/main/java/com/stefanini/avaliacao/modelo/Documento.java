package com.stefanini.avaliacao.modelo;

import java.time.LocalDate;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;


@MappedSuperclass
public abstract class Documento {

	@Id
	private String numeroRegistro;
	private String nome;
	private LocalDate nascimento;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getNascimento() {
		return nascimento;
	}

	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}

	public String getNumeroRegistro() {
		return numeroRegistro;
	}

	public void setNumeroRegistro(String numeroRegistro) {
		this.numeroRegistro = numeroRegistro;
	}

}
