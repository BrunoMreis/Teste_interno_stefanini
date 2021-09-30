package com.stefanini.avaliacao.modelo;

import java.time.LocalDate;

public class CNH extends TipoDocumento {

	private LocalDate validade;
	private LocalDate primeiraHabilitacao;

	private String categoriaHabilitacao;
	private String mae;
	private String pai;
	private CPF cpf;
	private RG rg;

	public LocalDate getValidade() {
		return validade;
	}

	public void setValidade(LocalDate validade) {
		this.validade = validade;
	}

	public LocalDate getPrimeiraHabilitacao() {
		return primeiraHabilitacao;
	}

	public void setPrimeiraHabilitacao(LocalDate primeiraHabilitacao) {
		this.primeiraHabilitacao = primeiraHabilitacao;
	}

	public String getCategoriaHabilitacao() {
		return categoriaHabilitacao;
	}

	public void setCategoriaHabilitacao(String categoriaHabilitacao) {
		this.categoriaHabilitacao = categoriaHabilitacao;
	}

	public String getMae() {
		return mae;
	}

	public void setMae(String mae) {
		this.mae = mae;
	}

	public String getPai() {
		return pai;
	}

	public void setPai(String pai) {
		this.pai = pai;
	}

	public CPF getCpf() {
		return cpf;
	}

	public void setCpf(CPF cpf) {
		this.cpf = cpf;
	}

	public RG getRg() {
		return rg;
	}

	public void setRg(RG rg) {
		this.rg = rg;
	}

}
