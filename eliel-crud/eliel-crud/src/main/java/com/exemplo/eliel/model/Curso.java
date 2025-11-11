package com.exemplo.eliel.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.*;
@Entity
public class Curso {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @NotBlank
  private String nome;
  @NotNull
  private Integer cargaHoraria;
  @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
  private List<Aluno> alunos = new ArrayList<>();
  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }
  public String getNome() { return nome; }
  public void setNome(String nome) { this.nome = nome; }
  public Integer getCargaHoraria() { return cargaHoraria; }
  public void setCargaHoraria(Integer cargaHoraria) { this.cargaHoraria = cargaHoraria; }
  public List<Aluno> getAlunos() { return alunos; }
  public void setAlunos(List<Aluno> alunos) { this.alunos = alunos; }
}
