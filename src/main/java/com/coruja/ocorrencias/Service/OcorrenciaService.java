package com.coruja.ocorrencias.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.coruja.ocorrencias.dto.OcorrenciaDTO;
import com.coruja.ocorrencias.model.OcorrenciaEntity;
@Service
public class OcorrenciaService {

    private List<ValidaOcorrenciaInterface> validacoes;
    private final OcorrenciaEntity reposiory;

    public OcorrenciaService(List<ValidaOcorrenciaInterface> validacoes, OcorrenciaEntity reposiory) {
        this.validacoes = validacoes;
        this.reposiory = reposiory;
    }

    public void salvar(OcorrenciaDTO dto) {

        validacoes.forEach(interfacevalidar -> interfacevalidar.validar(dto));
        // Para cada classe que implementar a interface ValidaOcorrencia vai fazer o
        // interfaceValidar.validar, vai executar o metodo validar dentro delas com o
        // (dto) como parametro.

        List<String> caminhos = new ArrayList<>();

        Path pastaUpload = Path.of("upload");
        Files.createDirectories(pastaUpload);

        for (MultipartFile foto : dto.getFoto()){
            

        }




        OcorrenciaEntity entity = new OcorrenciaEntity();
        entity.setTitulo(dto.getTitulo());
        entity.setDescricao(dto.getDescricao());
        entity.setDataCriacao(LocalDateTime.now());
        entity.setEmailDestino(dto.getEmailDestino());
        
    }
}
