package com.example.demo.model.controller;

import com.example.demo.model.Response.Response;
import com.example.demo.model.Response.ResponseAlterarPessoa;
import com.example.demo.model.dto.DadosPessoa;
import com.example.demo.model.dto.DadosPessoaAlterar;
import com.example.demo.model.entitys.Pessoa;
import com.example.demo.model.repository.PessoaRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    public PessoaController(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }
    PessoaRepository pessoaRepository;

    //- Adicionar um pessoa (post/pessoas)
    //
    //- Alterar um pessoa (put/pessoas/{id})
    //
    //- Remover pessoa (delete/pessoas/{id})

    @PostMapping
    @Transactional
    public ResponseEntity<?> addPessoa(@Valid @RequestBody DadosPessoa dados){
        pessoaRepository.save(new Pessoa(dados));
        return ResponseEntity.ok(dados);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseAlterarPessoa> alterPessoa(@RequestBody DadosPessoaAlterar dados, @PathVariable("id")Long id){
        Optional<Pessoa> p = pessoaRepository.findById(id);
        if (!p.isPresent()){
            return ResponseEntity.notFound().build();
        }
        p.get().atualizar(dados);
        pessoaRepository.save(p.get());
        return ResponseEntity.ok(new ResponseAlterarPessoa(p.get().getNome(),p.get().getDepartamentoEnum()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePessoa(@PathVariable Long id){
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        if (!pessoa.isPresent()){
            return ResponseEntity.notFound().build();
        }
        pessoaRepository.deleteById(id);
        return ResponseEntity.ok().body(new Response("Deletado"));
    }
}
