package com.exemplo.eliel.service;
import org.springframework.stereotype.Service;
import java.util.*;
import com.exemplo.eliel.model.Aluno;
import com.exemplo.eliel.model.Curso;
import com.exemplo.eliel.repository.AlunoRepository;
import com.exemplo.eliel.repository.CursoRepository;
@Service
public class AlunoService {
  private final AlunoRepository repository;
  private final CursoRepository cursoRepository;
  public AlunoService(AlunoRepository repository, CursoRepository cursoRepository) {
    this.repository = repository;
    this.cursoRepository = cursoRepository;
  }
  public List<Aluno> listar() { return repository.findAll(); }
  public Aluno buscar(Long id) { return repository.findById(id).orElseThrow(() -> new RuntimeException("Aluno não encontrado")); }
  public Aluno salvar(Aluno a) {
    if (a.getCurso() == null || a.getCurso().getId() == null) throw new RuntimeException("Curso obrigatório");
    Curso curso = cursoRepository.findById(a.getCurso().getId()).orElseThrow(() -> new RuntimeException("Curso não encontrado"));
    a.setCurso(curso);
    return repository.save(a);
  }
  public Aluno atualizar(Long id, Aluno a) {
    Aluno existente = buscar(id);
    existente.setNome(a.getNome());
    existente.setMatricula(a.getMatricula());
    existente.setStatus(a.getStatus());
    if (a.getCurso() != null && a.getCurso().getId() != null) {
      Curso curso = cursoRepository.findById(a.getCurso().getId()).orElseThrow(() -> new RuntimeException("Curso não encontrado"));
      existente.setCurso(curso);
    }
    return repository.save(existente);
  }
  public void deletar(Long id) { repository.delete(buscar(id)); }
}
