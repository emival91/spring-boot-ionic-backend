package com.cursomodelagem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursomodelagem.domain.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {

}
