package com.indra.videoclub.serviceImpl;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import com.indra.videoclub.dto.UsuarioDTO;
import com.indra.videoclub.entity.Usuario;
import com.indra.videoclub.repository.UsuarioRepository;
import com.indra.videoclub.service.UsuarioService;



@Service
public class UsuarioServiceImpl implements UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	ModelMapper modelMapper;

	@Override
	public List<UsuarioDTO> findAll() {
		List<Usuario> usuarios = usuarioRepository.findAll();
		return usuarios.stream().map(this::convertirToDto).collect(Collectors.toList());
	}

	@Override
	public UsuarioDTO findById(Long id) {
		return convertirToDto(usuarioRepository.findById(id).get());
	}

	@Override
	public UsuarioDTO save(UsuarioDTO usuarioDto) throws ParseException {

		return convertirToDto(usuarioRepository.save(convertirToEntidad(usuarioDto)));
	}

	@Override
	public UsuarioDTO update(Long id, UsuarioDTO usuarioDto) {
		
		Usuario usuarioToUpdate = usuarioRepository.findById(id).get();
		
		if (usuarioDto.getNombre() != null) {
			usuarioToUpdate.setNombre(usuarioDto.getNombre());
		}
		if (usuarioDto.getApellidos() != null) {
			usuarioToUpdate.setApellidos(usuarioDto.getApellidos());
		}
		if (usuarioDto.getTelefono() != null) {
			usuarioToUpdate.setTelefono(usuarioDto.getTelefono());
		}
		if (usuarioDto.getDnie() != null) {
			usuarioToUpdate.setDnie(usuarioDto.getDnie());
		}

		return convertirToDto(usuarioRepository.save(usuarioToUpdate));
	}

	@Override
	public void deleteById(Long id) {
		usuarioRepository.deleteById(id);
	}


	private UsuarioDTO convertirToDto(Usuario usuario) {
		UsuarioDTO usuarioDto = modelMapper.map(usuario, UsuarioDTO.class);
		return usuarioDto;
	}

	private Usuario convertirToEntidad(UsuarioDTO usuarioDto) throws ParseException {
		Usuario usuario = modelMapper.map(usuarioDto, Usuario.class);
		return usuario;
	}



}
