package com.exemplo.eliel.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;
import java.net.URI;
import java.util.*;
import com.exemplo.eliel.model.Curso;
import com.exemplo.eliel.service.CursoService;
@RestController
@RequestMapping("/cursos")
public class CursoController {
  private final CursoService service;
  public CursoController(CursoService service) { this.service = service; }
  @PostMapping
  public ResponseEntity<Curso> criar(@RequestBody @Valid Curso c) {
    Curso salvo = service.salvar(c);
    return ResponseEntity.created(URI.create("/cursos/" + salvo.getId())).body(salvo);
  }
  @GetMapping
  public ResponseEntity<List<Curso>> listar() { return ResponseEntity.ok(service.listar()); }
  @GetMapping("/{id}")
  public ResponseEntity<Curso> buscar(@PathVariable Long id) { return ResponseEntity.ok(service.buscar(id)); }
  @PutMapping("/{id}")
  public ResponseEntity<Curso> atualizar(@PathVariable Long id, @RequestBody @Valid Curso c) { return ResponseEntity.ok(service.atualizar(id, c)); }
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletar(@PathVariable Long id) { service.deletar(id); return ResponseEntity.noContent().build(); }
}
