package com.bookstore.resource;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.domain.Livro;
import com.bookstore.service.LivroService;

@RestController
@RequestMapping("/livros")
public class LivroResource {

	@Autowired
	private LivroService livroResource;
	
	@GetMapping("/{id}")
	public ResponseEntity<Livro> findById (@PathVariable Integer id){
		Livro livro = this.livroResource.findById(id);
		return ResponseEntity.ok(livro);
	}
}
