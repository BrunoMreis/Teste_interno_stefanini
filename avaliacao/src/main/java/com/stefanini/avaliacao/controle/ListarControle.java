package com.stefanini.avaliacao.controle;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.stefanini.avaliacao.modelo.DocumentoIdentificacao;
import com.stefanini.avaliacao.modelo.Tipo;
import com.stefanini.avaliacao.repositorio.DocumentoIdentificacaoRepositorio;
import com.stefanini.avaliacao.service.ConversorJasonService;

@Controller
public class ListarControle {

	@Autowired
	private DocumentoIdentificacaoRepositorio repositorio;

	@GetMapping("/listar")
	public String listar(Model model) {

		List<DocumentoIdentificacao> lista = repositorio.findAll();
		
		String json = ConversorJasonService.converterJson(lista);
		model.addAttribute("lista", lista);
		model.addAttribute("json",json);
		return "lista";
	}

	@GetMapping("/listar/filtro/{data}")
	public String listarData(Model model, @PathVariable("data") String stringData) {
		LocalDate data = LocalDate.parse(stringData);
		
		List<DocumentoIdentificacao> lista = repositorio.findByData(data);
		model.addAttribute("lista", lista);
		return "lista";
	}
	
	@GetMapping("/listar/filtro/intervalo")
	public String listarData(Model model, @RequestParam("dataInicio") LocalDate dataInicio ,  @RequestParam("dataInicio") LocalDate dataFinal ) {
		List<DocumentoIdentificacao> lista = repositorio.findByDataBetween(dataInicio, dataFinal );
		model.addAttribute("lista", lista);
		return "lista";
	}
	
	
	@GetMapping("/listar/filtro/data/inicial")
	public String listarDataInicial(Model model, @RequestParam("dataInicio") LocalDate dataInicio) {
		List<DocumentoIdentificacao> lista = repositorio.findByDataGreaterThanEqual(dataInicio);
		model.addAttribute("lista", lista);
		return "lista";
	}
	
	@GetMapping("/listar/filtro/data/final")
	public String listarDataFinal(Model model, @RequestParam("dataInicio") LocalDate dataFinal) {
		List<DocumentoIdentificacao> lista = repositorio.findByDataLessThanEqual(dataFinal);
		model.addAttribute("lista", lista);
		return "lista";
	}
	
	
	 @GetMapping("/listar/filtro/tipo")
	 public String listarTipo(Model model, @RequestParam("Tipo") Tipo tipo) {
		 List<DocumentoIdentificacao> lista = repositorio.findByTipo(tipo);
		 model.addAttribute("lista", lista);
		 return "lista";
	 }
}
