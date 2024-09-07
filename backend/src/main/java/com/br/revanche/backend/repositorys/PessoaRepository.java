package com.br.revanche.backend.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.revanche.backend.models.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
  
}
