package com.stefanini.avaliacao.controle;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.stefanini.avaliacao.modelo.DocumentoIdentificacao;
import com.stefanini.avaliacao.modelo.Tipo;
import com.stefanini.avaliacao.repositorio.DocumentoIdentificacaoRepositorio;

@WebMvcTest(UploadControle.class)
class UploadControleTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private DocumentoIdentificacaoRepositorio repositorio;

    @Test
    void testHomepage() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk());
    }

    @Test
    void testUploadFileVazio() throws Exception {
        MockMultipartFile file = new MockMultipartFile("file", "", "image/png", new byte[0]);
        mockMvc.perform(multipart("/upload").file(file)
                .flashAttr("documentoIdentificacao", new DocumentoIdentificacao()))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"));
    }

    @Test
    void testUploadFileValido() throws Exception {
        DocumentoIdentificacao doc = new DocumentoIdentificacao();
        doc.setId(1L);
        doc.setTipo(Tipo.RG);
        when(repositorio.save(any())).thenReturn(doc);

        MockMultipartFile file = new MockMultipartFile("file", "teste.png", "image/png", "conteudo".getBytes());

        mockMvc.perform(multipart("/upload").file(file)
                .flashAttr("documentoIdentificacao", doc))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"));
    }

    @Test
    void testUploadFileNomeInvalido() throws Exception {
        DocumentoIdentificacao doc = new DocumentoIdentificacao();
        doc.setId(1L);
        doc.setTipo(Tipo.RG);
        when(repositorio.save(any())).thenReturn(doc);

        // Nome de arquivo com path traversal
        MockMultipartFile file = new MockMultipartFile("file", "../malicioso.png", "image/png", "conteudo".getBytes());

        mockMvc.perform(multipart("/upload").file(file)
                .flashAttr("documentoIdentificacao", doc))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"));
    }
}
