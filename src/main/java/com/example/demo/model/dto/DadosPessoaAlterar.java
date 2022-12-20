package com.example.demo.model.dto;

import com.example.demo.model.services.Departamento;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;

@Getter
public class DadosPessoaAlterar {
    String nome;
    @JsonProperty(value = "departamento")
    @Enumerated(EnumType.STRING)
    Departamento departamentoEnum;

    public DadosPessoaAlterar() {

    }
}
