package com.cursomodelagem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursomodelagem.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
