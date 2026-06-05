package com.coruja.ocorrencias.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.coruja.ocorrencias.dto.OcorrenciaDTO;
import com.coruja.ocorrencias.model.OcorrenciaEntity;
import com.coruja.ocorrencias.repository.RepositoryJPA;

@Service
public class OcorrenciaService {

    private List<ValidaOcorrenciaInterface> validacoes;
    private final RepositoryJPA repository;


    public OcorrenciaService(List<ValidaOcorrenciaInterface> validacoes, RepositoryJPA repository) {
        this.validacoes = validacoes;
        this.repository = repository;
    }



    public OcorrenciaEntity salvar(OcorrenciaDTO dto) {

        validacoes.forEach(interfacevalidar -> interfacevalidar.validar(dto));
        // Para cada classe que implementar a interface ValidaOcorrencia vai fazer o
        // interfaceValidar.validar, vai executar o metodo validar dentro delas com o
        // (dto) como parametro.

        List<String> caminhos = new ArrayList<>();

        Path pastaUpload = Path.of("upload");
        try {
            for (MultipartFile caminhofotos : dto.getFoto()){
             Files.createDirectories(pastaUpload);
     
 
             String caminho = caminhofotos.getOriginalFilename();
 
             String nomeOriginal = UUID.randomUUID() + "-" + caminho;
 
             Path destino = pastaUpload.resolve(nomeOriginal);
 
             caminhofotos.transferTo(destino);
 
             caminhos.add("ocorrencias" + nomeOriginal);
         }
 
       } catch (IOException e) {
        throw new RuntimeException("Erro ao salvar foto na pasta upload - local", e);
       }

         OcorrenciaEntity entity = new OcorrenciaEntity();
        entity.setTitulo(dto.getTitulo());
        entity.setDescricao(dto.getDescricao());
        entity.setDataCriacao(LocalDateTime.now());
        entity.setEmailDestino(dto.getEmailDestino());
        entity.setCaminhoFoto(caminhos);

        return repository.save(entity);

    }
}
