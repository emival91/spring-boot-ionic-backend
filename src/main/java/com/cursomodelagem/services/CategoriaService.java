package com.cursomodelagem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursomodelagem.domain.Categoria;
import com.cursomodelagem.repositories.CategoriaRepository;
import com.cursomodelagem.services.exceptions.ObjectNotfounException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		Categoria obj = repo.findOne(id);
		if (obj == null) {
			throw new ObjectNotfounException("Objeto não encontrado id: " + id
					+ ", Tipo " + Categoria.class.getName());
		}
		return obj;
	}

}
