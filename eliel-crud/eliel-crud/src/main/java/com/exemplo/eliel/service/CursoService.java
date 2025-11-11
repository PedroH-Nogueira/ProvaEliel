package com.exemplo.eliel.service;
import org.springframework.stereotype.Service;
import java.util.*;
import com.exemplo.eliel.model.Curso;
import com.exemplo.eliel.repository.CursoRepository;
@Service
public class CursoService {
  private final CursoRepository repository;
  public CursoService(CursoRepository repository) { this.repository = repository; }
  public List<Curso> listar() { return repository.findAll(); }
  public Curso buscar(Long id) { return repository.findById(id).orElseThrow(() -> new RuntimeException("Curso não encontrado")); }
  public Curso salvar(Curso c) { return repository.save(c); }
  public Curso atualizar(Long id, Curso c) {
    Curso existente = buscar(id);
    existente.setNome(c.getNome());
    existente.setCargaHoraria(c.getCargaHoraria());
    return repository.save(existente);
  }
  public void deletar(Long id) { repository.delete(buscar(id)); }
}
