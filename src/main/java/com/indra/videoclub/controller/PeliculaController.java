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

import com.indra.videoclub.dto.PeliculaDTO;
import com.indra.videoclub.serviceImpl.PeliculaServiceImpl;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("api/peliculas")
@CrossOrigin(origins = "*")

public class PeliculaController {

	@Autowired
	PeliculaServiceImpl peliculaService;

	@ApiOperation(value = "Busca todos las peliculas")
	@GetMapping
	public ResponseEntity<List<PeliculaDTO>> findAll() {
		return ResponseEntity.ok(peliculaService.findAll());
	}

	@ApiOperation(value = "Crea una pelicula dando un array, Req.Mínimo: 'id_categoria', 'titulo', 'esta_disponible'")
	@PostMapping
	public ResponseEntity<PeliculaDTO> create(@RequestBody PeliculaDTO peliculaDto) throws ParseException {
		return ResponseEntity.ok(peliculaService.save(peliculaDto));
	}

	@ApiOperation(value = "Busca una pelicula")
	@GetMapping("/{id}")
	public ResponseEntity<PeliculaDTO> findById(@PathVariable Long id) {
		return ResponseEntity.ok(peliculaService.findById(id));
	}

	@ApiOperation(value = "Edita una pelicula dando un array. Opciones: 'id_categoria' o 'titulo' o 'esta_disponible'")
	@PatchMapping("/{id}")
	public ResponseEntity<PeliculaDTO> update(@PathVariable Long id, @RequestBody PeliculaDTO usuarioDto) {
		return ResponseEntity.ok(peliculaService.update(id, usuarioDto));
	}

	@ApiOperation(value = "Borra de manera fisica una pelicula")
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		peliculaService.deleteById(id);
		return ResponseEntity.ok("Pelicula borrada correctamente");
	}

}
