package com.example.demo.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class addPessoaEmTarefaDTO {
    @NotNull
    @JsonProperty("id_pessoa")
    private Long id;

    public Long getId() {
        return id;
    }

    public addPessoaEmTarefaDTO(){
}
}
