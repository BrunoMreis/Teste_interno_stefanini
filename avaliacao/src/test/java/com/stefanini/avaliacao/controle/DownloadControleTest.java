package com.stefanini.avaliacao.controle;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.stefanini.avaliacao.modelo.DocumentoIdentificacao;
import com.stefanini.avaliacao.modelo.Tipo;
import com.stefanini.avaliacao.repositorio.DocumentoIdentificacaoRepositorio;

@WebMvcTest(DownloadControle.class)
class DownloadControleTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private DocumentoIdentificacaoRepositorio repositorio;

    @Test
    void testDownloadArquivoNaoEncontrado() throws Exception {
        when(repositorio.findById(1L)).thenReturn(Optional.empty());
        mockMvc.perform(get("/download/1"))
                .andExpect(status().isNotFound()); // O método retorna null, pode ser melhorado para retornar erro
    }

    @Test
    void testDownloadArquivoSucesso(@TempDir File tempDir) throws Exception {
        // Cria arquivo temporário
        File file = new File(tempDir, "teste.txt");
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write("conteudo".getBytes());
        }
        DocumentoIdentificacao doc = new DocumentoIdentificacao();
        doc.setId(2L);
        doc.setLocalDoArquivo(file.getAbsolutePath());
        doc.setTipo(Tipo.RG);
        when(repositorio.findById(2L)).thenReturn(Optional.of(doc));
        mockMvc.perform(get("/download/2"))
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Diposition", "attachment; filename=" + file.getName()));
    }
}
