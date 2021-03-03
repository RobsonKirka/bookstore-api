/**
 * 
 */
package com.bookstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.domain.Categoria;
import com.bookstore.repositories.CategoriaRepository;

/**
 * @author robson.kirka
 *
 */
@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria findById (Integer id) {
		Optional<Categoria> categoria =  categoriaRepository.findById(id);
		return categoria.orElse(null);
	}
	
}
