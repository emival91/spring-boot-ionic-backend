package com.cursomodelagem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursomodelagem.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
