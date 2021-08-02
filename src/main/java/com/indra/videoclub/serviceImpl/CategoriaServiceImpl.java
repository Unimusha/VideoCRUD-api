package com.indra.videoclub.serviceImpl;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.indra.videoclub.dto.CategoriaDTO;
import com.indra.videoclub.entity.Categoria;
import com.indra.videoclub.repository.CategoriaRepository;
import com.indra.videoclub.service.CategoriaService;



@Service
public class CategoriaServiceImpl implements CategoriaService {
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	ModelMapper modelMapper;

	@Override
	public List<CategoriaDTO> findAll() {
		List<Categoria> categoria = categoriaRepository.findAll();
		return categoria.stream().map(this::convertirToDto).collect(Collectors.toList());
	}

	@Override
	public CategoriaDTO findById(Long id) {
		return convertirToDto(categoriaRepository.findById(id).get());
	}

	@Override
	public CategoriaDTO save(CategoriaDTO categoriaDto) throws ParseException {

		return convertirToDto(categoriaRepository.save(convertirToEntidad(categoriaDto)));
	}

	@Override
	public CategoriaDTO update(Long id, CategoriaDTO categoriaDto) {
		
		Categoria categoriaToUpdate = categoriaRepository.findById(id).get();
		
		if (categoriaDto.getNombre() != null) {
			categoriaToUpdate.setNombre(categoriaDto.getNombre());
		}

		return convertirToDto(categoriaRepository.save(categoriaToUpdate));
	}

	@Override
	public void deleteById(Long id) {
		categoriaRepository.deleteById(id);
	}


	private CategoriaDTO convertirToDto(Categoria categoria) {
		CategoriaDTO categoriaDto = modelMapper.map(categoria, CategoriaDTO.class);
		return categoriaDto;
	}

	private Categoria convertirToEntidad(CategoriaDTO categoriaDto) throws ParseException {
		Categoria categoria = modelMapper.map(categoriaDto, Categoria.class);
		return categoria;
	}



}
