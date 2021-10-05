package com.stefanini.avaliacao.controle;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.Optional;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.stefanini.avaliacao.modelo.DocumentoIdentificacao;
import com.stefanini.avaliacao.repositorio.DocumentoIdentificacaoRepositorio;

@Controller
public class DownloadControle {

	//private static final String EXTERNAL_FILE_PATH = "./diretorioRaiz/";
	
	@Autowired
	private DocumentoIdentificacaoRepositorio repositorio;
	
	@GetMapping("/download/{id}")
	public String downloads(@PathVariable Long id, HttpServletResponse response) throws IOException {
		
		Optional<DocumentoIdentificacao> optional = repositorio.findById(id);
		
		String 	path = verificaBuscaERetornaPath(optional);
		
		File file = new File(path);
		
		response.setContentType("application/octet-stream");
		
		ServletOutputStream outputStream = response.getOutputStream();
		
		BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file));
		
		byte[] buffer = new byte[8192]; //8 KB buffer
		int bytesRead = -1;
		
		while ((bytesRead = inputStream.read(buffer)) != -1) {
			outputStream.write(buffer, 0 ,bytesRead);
		}
		
		inputStream.close();
		outputStream.close();
		
		return "/lista";
		
	}



	private String verificaBuscaERetornaPath(Optional<DocumentoIdentificacao> optional) {
		String path;
		
		if (optional.isPresent()) {
			 path = optional.get().getLocalDoArquivo();
		}else {
			return null;//metado para errorpagina////////////////
		}
		return path;
	}
}
