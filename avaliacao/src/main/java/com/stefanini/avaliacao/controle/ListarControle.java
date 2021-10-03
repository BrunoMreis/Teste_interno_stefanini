package com.stefanini.avaliacao.controle;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.stefanini.avaliacao.modelo.DocumentoIdentificacao;
import com.stefanini.avaliacao.modelo.Tipo;
import com.stefanini.avaliacao.repositorio.DocumentoIdentificacaoRepositorio;

@Controller
public class ListarControle {

	@Autowired
	private DocumentoIdentificacaoRepositorio repositorio;

	@GetMapping("/listar")
	public String listar(Model model) {

		List<DocumentoIdentificacao> lista = repositorio.findAll();
		model.addAttribute("lista", lista);
		return "lista";
	}

	@GetMapping("/listar/filtro/data")
	public String listarData(Model model, @RequestParam("dataInicio") LocalDate dataInicio,
			@RequestParam("dataFim") LocalDate dataFim) {
		List<DocumentoIdentificacao> lista = repositorio.findByData(dataInicio, dataFim);
		model.addAttribute("lista", lista);
		return "lista";
	}
	
	
	@GetMapping("/listar/filtro/data/inicial")
	public String listarDataInicial(Model model, @RequestParam("dataInicio") LocalDate dataInicio) {
		List<DocumentoIdentificacao> lista = repositorio.findByDataInicial(dataInicio);
		model.addAttribute("lista", lista);
		return "lista";
	}
	
	@GetMapping("/listar/filtro/data/final")
	public String listarDataFinal(Model model, @RequestParam("dataInicio") LocalDate dataFinal) {
		List<DocumentoIdentificacao> lista = repositorio.findByDataInicial(dataFinal);
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
