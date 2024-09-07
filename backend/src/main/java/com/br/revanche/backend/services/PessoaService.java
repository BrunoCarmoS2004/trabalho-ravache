package com.br.revanche.backend.services;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.br.revanche.backend.models.Pessoa;
import com.br.revanche.backend.repositorys.PessoaRepository;

@Service
public class PessoaService {
  @Autowired
  private PessoaRepository pessoaRepository;

  public ResponseEntity<List<Pessoa>> listarPessoas(){
    List<Pessoa> listaPessoas = pessoaRepository.findAll();
    if (listaPessoas.isEmpty()) {
      return ResponseEntity.ok(Collections.emptyList());
    }
    return ResponseEntity.ok(pessoaRepository.findAll());
  }

  public ResponseEntity<Pessoa> pessoaPorId(long id){
    if (id == 0) {
      return ResponseEntity.badRequest().build();
    }
    Pessoa pessoa = pessoaRepository.findById(id).orElse(null);
    if (pessoa == null) {
      return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok(pessoa);
  }

  public ResponseEntity<Pessoa> criarPessoa(Pessoa pessoa){
    if (pessoa == null) {
      return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok(pessoaRepository.save(pessoa));
  }

  public ResponseEntity<Pessoa> atualizarPessoa(long id, Pessoa pessoa){
    Pessoa pessoaAtualizar = pessoaRepository.findById(id).orElse(null);
    if (pessoa == null) {
      return ResponseEntity.badRequest().build();
    }
    pessoaAtualizar = pessoa;
    pessoaAtualizar.setId(id);
    return ResponseEntity.ok(pessoaRepository.save(pessoaAtualizar));
  }

  public ResponseEntity<?> deletarPessoa(long id){
    if (id == 0) {
      return ResponseEntity.badRequest().build();
    }
    pessoaRepository.deleteById(id);
    return ResponseEntity.ok().build();
  }
}
