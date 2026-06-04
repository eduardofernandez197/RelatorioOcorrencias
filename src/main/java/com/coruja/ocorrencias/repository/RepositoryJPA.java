package com.coruja.ocorrencias.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coruja.ocorrencias.model.OcorrenciaEntity;


public interface RepositoryJPA extends JpaRepository<OcorrenciaEntity, Long> {

    

}
