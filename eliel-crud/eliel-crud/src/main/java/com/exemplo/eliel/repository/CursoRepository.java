package com.exemplo.eliel.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.exemplo.eliel.model.Curso;
public interface CursoRepository extends JpaRepository<Curso, Long> {}
