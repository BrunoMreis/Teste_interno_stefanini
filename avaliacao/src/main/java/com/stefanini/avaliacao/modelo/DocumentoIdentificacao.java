package com.stefanini.avaliacao.modelo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DocumentoIdentificacao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private Tipo tipo;

	@Column
	private LocalDate data;

	@Column
	private String localDoArquivo;

	public DocumentoIdentificacao() {
		data = LocalDate.now();
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public String getLocalDoArquivo() {
		return localDoArquivo;
	}

	public void setLocalDoArquivo(String localDoArquivo) {
		this.localDoArquivo = localDoArquivo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "DocumentoIdentificacao [id=" + id + ", tipo=" + tipo + ", data=" + data + ", localDoArquivo="
				+ localDoArquivo + "]";
	}

}
