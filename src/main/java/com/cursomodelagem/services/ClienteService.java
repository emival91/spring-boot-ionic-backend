package com.cursomodelagem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursomodelagem.domain.Cliente;
import com.cursomodelagem.repositories.ClienteRepository;
import com.cursomodelagem.services.exceptions.ObjectNotfounException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente buscar(Integer id) {
		Cliente obj = repo.findOne(id);
		if (obj == null) {
			throw new ObjectNotfounException("Objeto não encontrado id: " + id
					+ ", Tipo " + Cliente.class.getName());
		}
		return obj;
	}

}
