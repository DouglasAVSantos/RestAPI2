package com.example.demo.model.entitys;

import com.example.demo.model.services.Departamento;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
    private int prazo;
    @Enumerated(EnumType.STRING)
    private Departamento departamento;
    private Long duracao;
    private String pessoaAlocada = null;
    private boolean finalizado;

    @ManyToOne
    @JoinColumn(name = "idpessoa")
    private Pessoa pessoa;


}