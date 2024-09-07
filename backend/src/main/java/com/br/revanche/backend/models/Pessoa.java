package com.br.revanche.backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pessoa {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @NotNull
  @NotBlank
  private String nome;
  @NotNull
  @NotBlank
  private String cpf;
  @NotNull
  @NotBlank
  private String telefone;
  @NotNull
  @NotBlank
  private String cep;
  @NotNull
  @NotBlank
  private String logradouro;
  @NotNull
  @NotBlank
  private String localidade;
  @NotNull
  @NotBlank
  private String estado;
}
