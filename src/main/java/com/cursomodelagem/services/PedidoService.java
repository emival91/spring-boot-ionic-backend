package com.cursomodelagem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursomodelagem.domain.Pedido;
import com.cursomodelagem.repositories.PedidoRepository;
import com.cursomodelagem.services.exceptions.ObjectNotfounException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	public Pedido buscar(Integer id) {
		Pedido obj = repo.findOne(id);
		if (obj == null) {
			throw new ObjectNotfounException("Objeto não encontrado id: " + id
					+ ", Tipo " + Pedido.class.getName());
		}
		return obj;
	}

}
