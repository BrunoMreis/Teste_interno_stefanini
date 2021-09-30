package com.stefanini.avaliacao.modelo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DocumentoIdentificacao {
	
	@Id
	private Long id;
	
	private TipoDocumento tipo;
	
	private LocalDate data;
	
	
	public DocumentoIdentificacao() {
		data = LocalDate.now();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public TipoDocumento getTipo() {
		return tipo;
	}


	public void setTipo(TipoDocumento tipo) {
		this.tipo = tipo;
	}


	public LocalDate getData() {
		return data;
	}


	public void setData(LocalDate data) {
		this.data = data;
	}
	
	
	

}
