package com.example.demo.model.repository;

import com.example.demo.model.entitys.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}