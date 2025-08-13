package com.stefanini.avaliacao.controle;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.HttpClientErrorException.NotFound;
import org.springframework.web.server.ResponseStatusException;

import com.stefanini.avaliacao.modelo.DocumentoIdentificacao;
import com.stefanini.avaliacao.repositorio.DocumentoIdentificacaoRepositorio;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class DownloadControle {

	// private static final String EXTERNAL_FILE_PATH = "./diretorioRaiz/";

	@Autowired
	private DocumentoIdentificacaoRepositorio repositorio;

	@GetMapping("/download/{id}")
	public void downloads(@PathVariable Long id, HttpServletResponse response) throws IOException {

		Optional<DocumentoIdentificacao> optional = repositorio.findById(id);

		String path = verificaBuscaERetornaPath(optional);

		File file = new File(path);

		response.setContentType("application/octet-stream");
		String headerKey = "Content-Diposition";
		String headerValue = "attachment; filename=" + file.getName();

		response.setHeader(headerKey, headerValue);

		ServletOutputStream outputStream = response.getOutputStream();

		BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file));

		byte[] buffer = new byte[8192]; // 8 KB buffer
		int bytesRead = -1;

		while ((bytesRead = inputStream.read(buffer)) != -1) {
			outputStream.write(buffer, 0, bytesRead);
		}

		inputStream.close();
		outputStream.flush();
		outputStream.close();

	}

	private String verificaBuscaERetornaPath(Optional<DocumentoIdentificacao> optional) {
		String path;

		if (optional.isPresent()) {
			path = optional.get().getLocalDoArquivo();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Documento não encontrado");
		}
		return path;
	}
}
