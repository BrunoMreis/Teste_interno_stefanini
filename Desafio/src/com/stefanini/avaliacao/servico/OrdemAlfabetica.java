package com.stefanini.avaliacao.servico;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OrdemAlfabetica {
	
	private List<String> lista;
	
	public OrdemAlfabetica(String arg[]) {

	this.lista = new ArrayList<String>();
		
		lista.addAll(Arrays.asList(arg));
		
	}

	public void ordenarCrescente() {
		Collections.sort(this.lista);
		
	}
	
	public void ordenarDecrescente() {
		Collections.sort(this.lista, Collections.reverseOrder());
		
		
	}

	public List<String> exibe() {
		
		return this.lista;
	}

}
