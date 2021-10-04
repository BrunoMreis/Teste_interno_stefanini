package com.stefanini.avaliacao.repositorio;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stefanini.avaliacao.modelo.DocumentoIdentificacao;
import com.stefanini.avaliacao.modelo.Tipo;

@Repository
@Transactional
public interface DocumentoIdentificacaoRepositorio extends JpaRepository<DocumentoIdentificacao, Long> {

	public List<DocumentoIdentificacao> findByData(LocalDate data);

	public List<DocumentoIdentificacao> findByDataBetween(LocalDate dataInicio, LocalDate dataFim);

	
	public List<DocumentoIdentificacao> findByDataGreaterThanEqual(LocalDate dataInicio);

	
	public List<DocumentoIdentificacao> findByDataLessThanEqual(LocalDate dataFinal);

	public List<DocumentoIdentificacao> findByTipo(Tipo tipo);

	public List<DocumentoIdentificacao> findByTipoAndData(Tipo tipo , LocalDate data);
	

	public List<DocumentoIdentificacao> findByTipoAndDataLessThanEqual(Tipo tipo , LocalDate dataFinal);
	

	public List<DocumentoIdentificacao> findByTipoAndDataGreaterThanEqual(Tipo tipo , LocalDate dataInicial);
	
	
	public List<DocumentoIdentificacao> findByTipoAndDataBetween(Tipo tipo , LocalDate dataInicial, LocalDate dataFinal);

}
