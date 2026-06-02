package com.coruja.ocorrencias.service.Validacoes;

import org.springframework.stereotype.Component;

import com.coruja.ocorrencias.dto.OcorrenciaDTO;
import com.coruja.ocorrencias.service.ValidaOcorrenciaInterface;
@Component
public class ValidaTitulo implements ValidaOcorrenciaInterface {

    public void validar (OcorrenciaDTO dto){
        if (dto.getTitulo() == null || dto.getTitulo() == (" ")) {
        throw new RuntimeException("Titulo nao pode ser vazio, ou nullo");      
        }
    }
    
}
