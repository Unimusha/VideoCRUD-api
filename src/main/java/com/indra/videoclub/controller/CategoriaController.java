package com.indra.videoclub.controller;


import java.text.ParseException;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.indra.videoclub.dto.CategoriaDTO;
import com.indra.videoclub.serviceImpl.CategoriaServiceImpl;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("api/categorias")
@CrossOrigin(origins = "*")

public class CategoriaController {

	@Autowired
	CategoriaServiceImpl categoriaService;

	@ApiOperation(value = "Busca todos las categorias")
	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> findAll() {
		return ResponseEntity.ok(categoriaService.findAll());
	}

	@ApiOperation(value = "Crea un usuario dando un array, Req.Mínimo: 'nombre'")
	@PostMapping
	public ResponseEntity<CategoriaDTO> create(@RequestBody CategoriaDTO categoriaDto) throws ParseException {
		return ResponseEntity.ok(categoriaService.save(categoriaDto));
	}

	@ApiOperation(value = "Busca una categoria")
	@GetMapping("/{id}")
	public ResponseEntity<CategoriaDTO> findById(@PathVariable Long id) {
		return ResponseEntity.ok(categoriaService.findById(id));
	}

	@ApiOperation(value = "Edita un categoria dando un array. Opciones: 'nombre'")
	@PatchMapping("/{id}")
	public ResponseEntity<CategoriaDTO> update(@PathVariable Long id, @RequestBody CategoriaDTO categoriaDto) {
		return ResponseEntity.ok(categoriaService.update(id, categoriaDto));
	}

	@ApiOperation(value = "Borra de manera fisica una categoria")
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		categoriaService.deleteById(id);
		return ResponseEntity.ok("Categoria borrada correctamente");
	}

}
