package com.example.demo.model.Response;

import com.example.demo.model.services.Departamento;

public class ResponseAlterarPessoa {
    private String nome;
    private Departamento departamento;
    public String getNome() {
        return nome;
    }
    public Departamento getDep() {
        return departamento;
    }
    public ResponseAlterarPessoa(String nome, Departamento departamentoEnum) {
        this.nome = nome;
        departamento = departamentoEnum;
    }
}
