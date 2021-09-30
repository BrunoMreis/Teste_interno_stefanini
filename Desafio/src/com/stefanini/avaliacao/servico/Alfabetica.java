package com.stefanini.avaliacao.servico;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Alfabetica {

	protected List<String> lista;

	public Alfabetica(String arg[]) {

		this.lista = new ArrayList<String>();

		lista.addAll(Arrays.asList(arg));

	}
}
