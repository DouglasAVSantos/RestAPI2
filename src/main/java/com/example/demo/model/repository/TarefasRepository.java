package com.example.demo.model.repository;

import com.example.demo.model.entitys.Tarefas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface TarefasRepository extends JpaRepository<Tarefas, Long> {
}