package com.example.demo.model.entitys;

import com.example.demo.model.dto.TarefaDTO;
import com.example.demo.model.services.Departamento;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "tarefas")
@NoArgsConstructor
@Getter
public class Tarefas {
    //Cada tarefa terá id, título, descrição, prazo, departamento,
    // duração, pessoa alocada e se já foi finalizado.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private final UUID uuid = UUID.randomUUID();
    private String titulo;
    private String descricao;
    private LocalDate prazo;
    @Enumerated(EnumType.STRING)
    private Departamento departamento;
    private Long duracao;
    private String pessoaAlocada = null;
    private boolean finalizado = false;

    public void setPessoaAlocada(String pessoaAlocada) {
        this.pessoaAlocada = pessoaAlocada;
    }

    @ManyToOne
    @JoinColumn(name = "idpessoa")
    private Pessoa pessoa;


    public Tarefas(TarefaDTO dados) {
        this.titulo = dados.getTitulo();
        this.descricao = dados.getDescricao();
        this.prazo = dados.getPrazo();
        this.departamento = dados.getDepartamento();
        this.duracao = dados.getDuracao();
    }
}