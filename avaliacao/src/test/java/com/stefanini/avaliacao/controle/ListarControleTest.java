package com.stefanini.avaliacao.controle;

    import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.stefanini.avaliacao.repositorio.DocumentoIdentificacaoRepositorio;
import com.stefanini.avaliacao.service.ConversorJasonService;

    @WebMvcTest(ListarControle.class)
    class ListarControleTest {
        @Autowired
        private MockMvc mockMvc;

        @MockitoBean
        private DocumentoIdentificacaoRepositorio repositorio;

        @MockitoBean
        private ConversorJasonService conversorJasonService;

        @Test
        void testListarTodos() throws Exception {
            when(repositorio.findAll()).thenReturn(Collections.emptyList());
            mockMvc.perform(get("/listar"))
                    .andExpect(status().isOk());
        }

        @Test
        void testListarPorData() throws Exception {
            when(repositorio.findByData(any(LocalDate.class))).thenReturn(Collections.emptyList());
            mockMvc.perform(get("/listar/filtro/2024-01-01"))
                    .andExpect(status().isOk());
        }

        @Test
        void testListarPorIntervalo() throws Exception {
            when(repositorio.findByDataBetween(any(LocalDate.class), any(LocalDate.class))).thenReturn(Collections.emptyList());
            mockMvc.perform(get("/listar/filtro/intervalo?dataInicio=2024-01-01&dataInicio=2024-01-10"))
                    .andExpect(status().isOk());
        }

        @Test
        void testListarDataInicial() throws Exception {
            when(repositorio.findByDataGreaterThanEqual(any(LocalDate.class))).thenReturn(Collections.emptyList());
            mockMvc.perform(get("/listar/filtro/data/inicial?dataInicio=2024-01-01"))
                    .andExpect(status().isOk());
        }

        @Test
        void testListarDataFinal() throws Exception {
            when(repositorio.findByDataLessThanEqual(any(LocalDate.class))).thenReturn(Collections.emptyList());
            mockMvc.perform(get("/listar/filtro/data/final?dataInicio=2024-01-10"))
                    .andExpect(status().isOk());
        }

        @Test
        void testListarTipo() throws Exception {
            when(repositorio.findByTipo(any())).thenReturn(Collections.emptyList());
            mockMvc.perform(get("/listar/filtro/tipo?Tipo=RG"))
                    .andExpect(status().isOk());
        }
    }
