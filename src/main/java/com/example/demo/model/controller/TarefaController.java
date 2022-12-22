package com.example.demo.model.controller;

import com.example.demo.model.Response.Response;
import com.example.demo.model.dto.DadosPessoa;
import com.example.demo.model.dto.TarefaDTO;
import com.example.demo.model.dto.addPessoaEmTarefaDTO;
import com.example.demo.model.entitys.Pessoa;
import com.example.demo.model.entitys.Tarefas;
import com.example.demo.model.repository.PessoaRepository;
import com.example.demo.model.repository.TarefasRepository;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
@NoArgsConstructor
@RequestMapping("/tarefas")
public class TarefaController {
    @Autowired TarefasRepository tarefasRepository;
    @Autowired PessoaRepository pessoaRepository;


    @PostMapping
    @Transactional
    public ResponseEntity<TarefaDTO> addTarefa(@RequestBody @Valid TarefaDTO dados){
        tarefasRepository.save(new Tarefas(dados));
        return ResponseEntity.ok(dados);
    }

    @PutMapping("/alocar/{id}")
    @Transactional
    public ResponseEntity<?> addPessoaEmTarefa(@RequestBody @Valid addPessoaEmTarefaDTO dados, @PathVariable Long id){
        Optional<Pessoa> pessoa = pessoaRepository.findById(dados.getId());
        Optional<Tarefas> tarefas = tarefasRepository.findById(id);
        if (!pessoa.isPresent() | !tarefas.isPresent()){
            return ResponseEntity.notFound().build();
        }
        if (pessoa.get().getDepartamentoEnum() == tarefas.get().getDepartamento()){
        pessoa.get().getListaDeTarefas().add(tarefas.get());
        tarefas.get().setPessoaAlocada(pessoa.get().getNome());
        tarefasRepository.save(tarefas.get());
        pessoaRepository.save(pessoa.get());
        return ResponseEntity.ok().build();}
        return ResponseEntity.badRequest().body(new Response("Os departamentos não são compativeis"));
    }

}
