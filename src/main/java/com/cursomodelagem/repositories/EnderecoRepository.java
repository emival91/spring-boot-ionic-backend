package com.cursomodelagem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursomodelagem.domain.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

}
