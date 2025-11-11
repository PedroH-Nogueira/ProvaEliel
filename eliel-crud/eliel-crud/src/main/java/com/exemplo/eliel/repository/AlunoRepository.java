package com.exemplo.eliel.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.exemplo.eliel.model.Aluno;
public interface AlunoRepository extends JpaRepository<Aluno, Long> {}
