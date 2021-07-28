package com.cursomodelagem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursomodelagem.domain.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
