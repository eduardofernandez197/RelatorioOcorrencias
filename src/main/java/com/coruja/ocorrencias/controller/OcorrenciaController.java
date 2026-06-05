package com.coruja.ocorrencias.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coruja.ocorrencias.dto.OcorrenciaDTO;
import com.coruja.ocorrencias.service.OcorrenciaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/ocorrencias")
public class OcorrenciaController {

    private final OcorrenciaService service;
    
public OcorrenciaController(OcorrenciaService service) {
        this.service = service;
    }
@PostMapping
public ResponseEntity<Void> salvar(@Valid @ModelAttribute OcorrenciaDTO dto){

    service.salvar(dto);
    

    return ResponseEntity.status(201).build();

}








}
