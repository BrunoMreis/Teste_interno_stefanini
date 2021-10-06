package com.stefanini.avaliacao.controle;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.stefanini.avaliacao.modelo.DocumentoIdentificacao;
import com.stefanini.avaliacao.repositorio.DocumentoIdentificacaoRepositorio;

@Controller
public class UploadControle {

	@Autowired
	private DocumentoIdentificacaoRepositorio repositorio;
	


	private final String UPLOAD_DIR = "./diretorioRaiz/";

	@GetMapping("/")
	public String homepage(Model model) {
		DocumentoIdentificacao documentoIdentificacao = new DocumentoIdentificacao();
		model.addAttribute("documentoIdentificacao", documentoIdentificacao);
		return "index";
	}

	@PostMapping("/upload")
	public String uploadFile(@RequestParam("file") MultipartFile file,
			@ModelAttribute(name = "documentoIdentificacao") DocumentoIdentificacao documentoIdentificacao,
			RedirectAttributes attributes) {
				

		if (file.isEmpty()) {
			attributes.addFlashAttribute("message", "Por favor Selecionar uma imagem do documento.");
			return "redirect:/";
		}
		
		documentoIdentificacao = repositorio.save(documentoIdentificacao);

		String[] arraySring = file.getOriginalFilename().split("\\.");
		String fileName ="."+ arraySring[1];
			
		
		String localDoArquivo = UPLOAD_DIR + documentoIdentificacao.getTipo() + "/imagem_"
				+ documentoIdentificacao.getTipo().getDoc() + "_" + documentoIdentificacao.getId()
				+ fileName;
		
		documentoIdentificacao.setLocalDoArquivo(localDoArquivo);
		repositorio.save(documentoIdentificacao);///não está legal passar para o bando gerar id atualizar o local e salvar novamente.
	
		
		
		try {
			
			Path path = Paths.get(localDoArquivo);
			Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}

		attributes.addFlashAttribute("message", "Documento enviado com sucesso " + '!');

		return "redirect:/";
	}
	



}
