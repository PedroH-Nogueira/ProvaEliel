package com.exemplo.eliel.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
@Entity
public class Aluno {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @NotBlank
  private String nome;
  @NotBlank
  private String matricula;
  @Enumerated(EnumType.STRING)
  private StatusAluno status;
  @ManyToOne
  private Curso curso;
  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }
  public String getNome() { return nome; }
  public void setNome(String nome) { this.nome = nome; }
  public String getMatricula() { return matricula; }
  public void setMatricula(String matricula) { this.matricula = matricula; }
  public StatusAluno getStatus() { return status; }
  public void setStatus(StatusAluno status) { this.status = status; }
  public Curso getCurso() { return curso; }
  public void setCurso(Curso curso) { this.curso = curso; }
}
