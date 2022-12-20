package com.example.demo.model.dto;

import com.example.demo.model.services.Departamento;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDate;
@Getter
public class TarefaDTO {
    @NotBlank
    private String titulo;
    @NotBlank
    private String descricao;
    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate prazo;
    @Enumerated(EnumType.STRING)
    @NotNull
    private Departamento departamento;
    @NotNull
    private Long duracao;

    public TarefaDTO() {
    }

}
