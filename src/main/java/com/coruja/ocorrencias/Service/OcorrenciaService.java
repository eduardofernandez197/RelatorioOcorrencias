package com.coruja.ocorrencias.service;

import java.time.LocalDateTime;
import java.util.List;

import com.coruja.ocorrencias.dto.OcorrenciaDTO;
import com.coruja.ocorrencias.repository.OcorrenciaEntity;

public class OcorrenciaService {

    private List<ValidaOcorrenciaInterface> validacoes;
    private final OcorrenciaEntity reposiory;
    private final String storagePath = "src/Upload/Ocorrencia";

    public OcorrenciaService(List<ValidaOcorrenciaInterface> validacoes, OcorrenciaEntity reposiory) {
        this.validacoes = validacoes;
        this.reposiory = reposiory;
    }

    public void salvar(OcorrenciaDTO dto) {

        validacoes.forEach(interfacevalidar -> interfacevalidar.validar(dto));
        // Para cada classe que implementar a interface ValidaOcorrencia vai fazer o
        // interfaceValidar.validar, vai executar o metodo validar dentro delas com o
        // (dto) como parametro.

        OcorrenciaEntity entity = new OcorrenciaEntity();
        entity.setTitulo(dto.getTitulo());
        entity.setDescricao(dto.getDescricao());
        entity.setDataCriacao(LocalDateTime.now());
        entity.setEmailDestino(dto.getEmailDestino());
        entity.setCaminhoFoto();
    }
}
