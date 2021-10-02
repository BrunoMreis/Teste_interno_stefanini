package com.stefanini.avaliacao.modelo;


public enum Tipo {
	
	CNH("cnh"),
	RG("rg"),
	CR("cr");

	private final String doc;
	
	private Tipo(String doc) {
		this.doc = doc;
	}
	
	public String getDoc() {
		
		return this.doc;
	}
	
	
}
