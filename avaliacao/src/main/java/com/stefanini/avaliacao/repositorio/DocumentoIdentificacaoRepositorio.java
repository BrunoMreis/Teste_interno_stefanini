package com.stefanini.avaliacao.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stefanini.avaliacao.modelo.DocumentoIdentificacao;

public interface DocumentoIdentificacaoRepositorio extends JpaRepository<DocumentoIdentificacao, Long> {

}
