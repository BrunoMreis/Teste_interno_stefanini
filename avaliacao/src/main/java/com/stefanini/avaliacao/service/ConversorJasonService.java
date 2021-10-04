package com.stefanini.avaliacao.service;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.stefanini.avaliacao.modelo.DocumentoIdentificacao;

public class ConversorJasonService {
	
	private static ObjectMapper mapper;
	
	
	public static String converterJson(List<DocumentoIdentificacao> lista)  {
		mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		String json = "";
		
		
		try {
			
			for (DocumentoIdentificacao documento : lista) {
				
				json = json + mapper.writeValueAsString(documento);
			}
			
			
			
			
			
			
			
			
		} catch (JsonProcessingException e) {
		
			e.printStackTrace();
		}
		return json;
		
		
	}


}
