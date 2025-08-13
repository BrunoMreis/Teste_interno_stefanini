package com.stefanini.avaliacao.modelo;

import java.time.LocalDate;


public class RG extends Documento {

	private LocalDate expedicao;
	private String mae;
	private String pai;
	private String naturalidade;
	private CPF cpf;
	private String origemDocumento;

	public LocalDate getExpedicao() {
		return expedicao;
	}

	public void setExpedicao(LocalDate expedicao) {
		this.expedicao = expedicao;
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

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public CPF getCpf() {
		return cpf;
	}

	public void setCpf(CPF cpf) {
		this.cpf = cpf;
	}

	public String getOrigemDocumento() {
		return origemDocumento;
	}

	public void setOrigemDocumento(String origemDocumento) {
		this.origemDocumento = origemDocumento;
	}

}
