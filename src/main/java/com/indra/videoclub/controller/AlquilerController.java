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

import com.indra.videoclub.dto.AlquilerDTO;
import com.indra.videoclub.serviceImpl.AlquilerServiceImpl;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("api/alquiler")
@CrossOrigin(origins = "*")

public class AlquilerController {

	@Autowired
	AlquilerServiceImpl alquilerService;

	@ApiOperation(value = "Busca todos los alquileres")
	@GetMapping
	public ResponseEntity<List<AlquilerDTO>> findAll() {
		return ResponseEntity.ok(alquilerService.findAll());
	}

	@ApiOperation(value = "Crea un usuario dando un array, Req.Mínimo: 'id_usuario', 'id_pelicula', 'esta_alquilada'")
	@PostMapping
	public ResponseEntity<AlquilerDTO> create(@RequestBody AlquilerDTO usuarioDto) throws ParseException {
		return ResponseEntity.ok(alquilerService.save(usuarioDto));
	}

	@ApiOperation(value = "Busca un alquiler")
	@GetMapping("/{id}")
	public ResponseEntity<AlquilerDTO> findById(@PathVariable Long id) {
		return ResponseEntity.ok(alquilerService.findById(id));
	}

	@ApiOperation(value = "Edita un usuario dando un array. Opciones: 'esta_alquilada'")
	@PatchMapping("/{id}")
	public ResponseEntity<AlquilerDTO> update(@PathVariable Long id, @RequestBody AlquilerDTO alquilerDto) {
		return ResponseEntity.ok(alquilerService.update(id, alquilerDto));
	}

	@ApiOperation(value = "Borra de manera fisica un alquiler")
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		alquilerService.deleteById(id);
		return ResponseEntity.ok("Alquiler borrado correctamente");
	}

}
