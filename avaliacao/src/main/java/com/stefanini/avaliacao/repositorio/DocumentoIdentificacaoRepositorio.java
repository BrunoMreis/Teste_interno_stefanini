package com.stefanini.avaliacao.repositorio;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stefanini.avaliacao.modelo.DocumentoIdentificacao;
import com.stefanini.avaliacao.modelo.Tipo;

@Repository
@Transactional
public interface DocumentoIdentificacaoRepositorio extends JpaRepository<DocumentoIdentificacao, Long> {

	
	
	
	
	public List<DocumentoIdentificacao> findByData(LocalDate data);
	
	public List<DocumentoIdentificacao> findByDataBetween( LocalDate dataInicio, LocalDate dataFim);
	
	@Query("select d from DocumentoIdentificacao d where d.data >= :dataInicio ")
	public List<DocumentoIdentificacao> findByDataInicial(@Param("dataInicio") LocalDate dataInicio);
	
	@Query("select d from DocumentoIdentificacao d where d.data <= :dataFinal")
	public List<DocumentoIdentificacao> findByDataFinal(@Param("dataFinal") LocalDate dataFinal);


	public List<DocumentoIdentificacao> findByTipo(Tipo tipo);


}
