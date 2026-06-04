package com.coruja.ocorrencias.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public class OcorrenciaDTO {

    @NotBlank(message = "Titulo é Obrigatório")
    private String titulo;
    @NotBlank(message = "Descrição é Obrigatório")
    private String descricao;
    @NotBlank(message = "E-mail e Obrigatório")
    @Email(message = "E-mail obrigatório")
    private String emailDestino;
    @NotEmpty(message = "Precisa encaminhar algum anexo")
    private List<MultipartFile> foto;


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEmailDestino() {
        return emailDestino;
    }

    public void setEmailDestino(String emailDestino) {
        this.emailDestino = emailDestino;
    }

    public List<MultipartFile> getFoto() {
        return foto;
    }

    public void setFoto(List<MultipartFile> foto) {
        this.foto = foto;
    }

}
