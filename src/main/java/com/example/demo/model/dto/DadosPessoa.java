package com.example.demo.model.dto;

import com.example.demo.model.services.Departamento;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class DadosPessoa {
    @NotBlank
    String nome;
    @NotNull @JsonProperty(value = "departamento") @Enumerated(EnumType.STRING)
    Departamento departamentoEnum;

    public DadosPessoa() {

    }
}
