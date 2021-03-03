/**
 * 
 */
package com.bookstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.domain.Livro;
import com.bookstore.repositories.LivroRepository;

/**
 * @author robson.kirka
 *
 */
@Service
public class LivroService {

	@Autowired
	private LivroRepository livroRepository;
	
	public Livro findById (Integer id) {
		Optional<Livro> livro = this.livroRepository.findById(id);
		return livro.orElse(null);
		
	}
	
}


