package com.example.demo.model.entitys;


import com.example.demo.model.dto.DadosPessoa;
import com.example.demo.model.dto.DadosPessoaAlterar;
import com.example.demo.model.services.Departamento;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

@Entity
@Table(name="pessoa")
@NoArgsConstructor
@Getter
public class Pessoa {
    //- Cada pessoa terá um id, nome, departamento e  lista de tarefas

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    private final UUID uuid = UUID.randomUUID();
    private String nome;
    @Enumerated(EnumType.STRING)
    @Column(name = "departamento")
    private Departamento departamentoEnum;
    @OneToMany
    @JoinColumn(name = "idpessoa")
    private List<Tarefas> listaDeTarefas = new java.util.ArrayList<>();

    public Pessoa(DadosPessoa dados) {
        this.nome = dados.getNome().toLowerCase(Locale.ROOT);
        this.departamentoEnum = dados.getDepartamentoEnum();
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "uuid=" + uuid +
                ", nome='" + nome + '\'' +
                ", departamentoEnum=" + departamentoEnum +
                '}';
    }

    public void atualizar(DadosPessoaAlterar dados){
        if (dados.getNome() != null){
            this.nome = dados.getNome().toLowerCase(Locale.ROOT);
        }
        if (dados.getDepartamentoEnum() != null){
            this.departamentoEnum = dados.getDepartamentoEnum();
        }
    }
}
