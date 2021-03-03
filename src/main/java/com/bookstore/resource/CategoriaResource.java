package com.bookstore.resource;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.CategoriaDTO;
import com.bookstore.domain.Categoria;
import com.bookstore.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

	@Autowired
	private CategoriaService categoriaService;

	@GetMapping("/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Integer id) {
		Categoria retorno = this.categoriaService.findById(id);
		return ResponseEntity.ok(retorno);
	}

	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> findAll() {
		List<Categoria> listaCategorias = this.categoriaService.findAll();
		List<CategoriaDTO> categoriasDTO = listaCategorias.stream().map(categoria -> new CategoriaDTO(categoria))
				.collect(Collectors.toList());

		return ResponseEntity.ok(categoriasDTO);
	}
}
