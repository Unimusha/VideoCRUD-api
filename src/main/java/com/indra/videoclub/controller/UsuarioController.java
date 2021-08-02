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

import com.indra.videoclub.dto.UsuarioDTO;
import com.indra.videoclub.serviceImpl.UsuarioServiceImpl;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("api/usuarios")
@CrossOrigin(origins = "*")

public class UsuarioController {

	@Autowired
	UsuarioServiceImpl usuarioService;

	@ApiOperation(value = "Busca todos los usuarios")
	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> findAll() {
		return ResponseEntity.ok(usuarioService.findAll());
	}

	@ApiOperation(value = "Crea un usuario dando un array, Req.Mínimo: 'nombre', 'apellidos', 'telefono', 'dnie'")
	@PostMapping
	public ResponseEntity<UsuarioDTO> create(@RequestBody UsuarioDTO usuarioDto) throws ParseException {
		return ResponseEntity.ok(usuarioService.save(usuarioDto));
	}

	@ApiOperation(value = "Busca un usuario")
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioDTO> findById(@PathVariable Long id) {
		return ResponseEntity.ok(usuarioService.findById(id));
	}

	@ApiOperation(value = "Edita un usuario dando un array. Opciones: 'nombre' o 'apellidos' o 'telefono' o 'dnie'")
	@PatchMapping("/{id}")
	public ResponseEntity<UsuarioDTO> update(@PathVariable Long id, @RequestBody UsuarioDTO usuarioDto) {
		return ResponseEntity.ok(usuarioService.update(id, usuarioDto));
	}

	@ApiOperation(value = "Borra de manera fisica un usuario")
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		usuarioService.deleteById(id);
		return ResponseEntity.ok("Usuario borrado correctamente");
	}

}
