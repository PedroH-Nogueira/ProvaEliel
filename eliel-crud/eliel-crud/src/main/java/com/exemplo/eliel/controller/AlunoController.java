package com.exemplo.eliel.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;
import java.net.URI;
import java.util.*;
import com.exemplo.eliel.model.Aluno;
import com.exemplo.eliel.service.AlunoService;
@RestController
@RequestMapping("/alunos")
public class AlunoController {
  private final AlunoService service;
  public AlunoController(AlunoService service) { this.service = service; }
  @PostMapping
  public ResponseEntity<Aluno> criar(@RequestBody @Valid Aluno a) {
    Aluno salvo = service.salvar(a);
    return ResponseEntity.created(URI.create("/alunos/" + salvo.getId())).body(salvo);
  }
  @GetMapping
  public ResponseEntity<List<Aluno>> listar() { return ResponseEntity.ok(service.listar()); }
  @GetMapping("/{id}")
  public ResponseEntity<Aluno> buscar(@PathVariable Long id) { return ResponseEntity.ok(service.buscar(id)); }
  @PutMapping("/{id}")
  public ResponseEntity<Aluno> atualizar(@PathVariable Long id, @RequestBody @Valid Aluno a) { return ResponseEntity.ok(service.atualizar(id, a)); }
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletar(@PathVariable Long id) { service.deletar(id); return ResponseEntity.noContent().build(); }
}
