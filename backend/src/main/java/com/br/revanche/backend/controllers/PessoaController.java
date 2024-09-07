package com.br.revanche.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.revanche.backend.models.Pessoa;
import com.br.revanche.backend.services.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
  @Autowired
  private PessoaService pessoaService;
  
  @GetMapping("/listar")
  public ResponseEntity<List<Pessoa>>listar(){
    return pessoaService.listarPessoas();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Pessoa>pessoaPorId(@PathVariable long id){
    return pessoaService.pessoaPorId(id);
  }
  
  @PostMapping("/criar")
  public ResponseEntity<Pessoa>criar(@RequestBody Pessoa pessoa){
    return pessoaService.criarPessoa(pessoa);
  }

  @PutMapping("/atualizar/{id}")
  public ResponseEntity<Pessoa>atualizar(@RequestBody Pessoa pessoa, @PathVariable long id){
    return pessoaService.atualizarPessoa(id, pessoa);
  }

  @DeleteMapping("/deletar/{id}")
  public ResponseEntity<?> deletar(@PathVariable long id){
    return pessoaService.deletarPessoa(id);
  }
}
