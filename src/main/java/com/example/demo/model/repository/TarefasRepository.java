package com.example.demo.model.repository;

import com.example.demo.model.entitys.Tarefas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefasRepository extends JpaRepository<Tarefas, Long> {
}