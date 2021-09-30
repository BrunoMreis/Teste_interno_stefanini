package com.stefanini.avaliacao.servico;

public class Fatiador extends Alfabetica {

	public Fatiador(String[] arg) {
		super(arg);
	
		
	}

 public void fatiar(String c, int n) {
	 String aux = c.substring(n, n*2);
	 n = c.length()- n;
	 String aux1 = c.substring(n);
	 
	 System.out.println(aux);
	 System.out.println(aux1);
 }
	
	

	
}
