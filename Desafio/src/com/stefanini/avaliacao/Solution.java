package com.stefanini.avaliacao;

import com.stefanini.avaliacao.servico.OrdemAlfabetica;

public class Solution {

	public static void main(String[] args) {
		
	
		OrdemAlfabetica ordenador = new OrdemAlfabetica(args);
		
		System.out.println(ordenador.exibe());
		
		ordenador.ordenarCrescente();
		
		System.out.println(ordenador.exibe());
		
		ordenador.ordenarDecrescente();
		
		System.out.println(ordenador.exibe());

	}

}
