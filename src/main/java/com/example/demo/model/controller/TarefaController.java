package com.example.demo.model.controller;

import com.example.demo.model.dto.TarefaDTO;
import com.example.demo.model.entitys.Tarefas;
import com.example.demo.model.repository.TarefasRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//- Adicionar um tarefa (post/tarefas)
//
//- Alocar uma pessoa na tarefa que tenha o mesmo departamento (put/tarefas/alocar/{id})
//
//- Finalizar a tarefa (put/tarefas/finalizar/{id})
//
//- Listar pessoas trazendo nome, departamento, total horas gastas nas tarefas.(get/pessoas)
//
//- Buscar pessoas por nome e período, retorna média de horas gastas por tarefa. (get/pessoas/gastos)
//
//- Listar 3 tarefas que estejam sem pessoa alocada com os prazos mais antigos. (get/tarefas/pendentes)
//
//- Listar departamento e quantidade de pessoas e tarefas (get/departamentos)
@RestController
@RequestMapping("/tarefas")
public class TarefaController {
    TarefasRepository tarefasRepository;
    public TarefaController(TarefasRepository tarefasRepository){
        this.tarefasRepository = tarefasRepository;
    }

    @PostMapping
    public ResponseEntity<TarefaDTO> addTarefa(@RequestBody @Valid TarefaDTO dados){
        tarefasRepository.save(new Tarefas(dados));
        return ResponseEntity.ok(dados);
    }

}
