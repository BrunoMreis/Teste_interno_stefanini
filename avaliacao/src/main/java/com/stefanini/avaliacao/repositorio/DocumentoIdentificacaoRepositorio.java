package com.stefanini.avaliacao.repositorio;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.stefanini.avaliacao.modelo.DocumentoIdentificacao;
import com.stefanini.avaliacao.modelo.Tipo;

public interface DocumentoIdentificacaoRepositorio extends JpaRepository<DocumentoIdentificacao, Long> {

	
	
	
	@Query("select d from DocumentoIdentificacao d where d.data between :dataInicio and :dataFim")
	public List<DocumentoIdentificacao> findByData(@Param("dataInicio") LocalDate dataInicio, @Param("dataFim") LocalDate dataFim);
	
	@Query("select d from DocumentoIdentificacao d where d.data >= :dataInicio ")
	public List<DocumentoIdentificacao> findByDataInicial(@Param("dataInicio") LocalDate dataInicio);
	
	@Query("select d from DocumentoIdentificacao d where d.data <= :dataFinal")
	public List<DocumentoIdentificacao> findByDataFinal(@Param("dataFinal") LocalDate dataFinal);

	@Query("select d from DocumentoIdetificacao d where d.tipo = :tipo")
	public List<DocumentoIdentificacao> findByTipo(@Param("tipo")Tipo tipo);


}
