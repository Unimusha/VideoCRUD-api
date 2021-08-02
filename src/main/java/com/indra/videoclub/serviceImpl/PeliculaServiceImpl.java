package com.indra.videoclub.serviceImpl;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.indra.videoclub.dto.PeliculaDTO;
import com.indra.videoclub.entity.Pelicula;
import com.indra.videoclub.repository.PeliculaRepository;
import com.indra.videoclub.service.PeliculaService;




@Service
public class PeliculaServiceImpl implements PeliculaService {
	@Autowired
	private PeliculaRepository peliculaRepository;
	@Autowired
	ModelMapper modelMapper;

	@Override
	public List<PeliculaDTO> findAll() {
		List<Pelicula> peliculas = peliculaRepository.findAll();
		return peliculas.stream().map(this::convertirToDto).collect(Collectors.toList());
	}

	@Override
	public PeliculaDTO findById(Long id) {
		return convertirToDto(peliculaRepository.findById(id).get());
	}

	@Override
	public PeliculaDTO save(PeliculaDTO peliculaDto) throws ParseException {

		return convertirToDto(peliculaRepository.save(convertirToEntidad(peliculaDto)));
	}

	@Override
	public PeliculaDTO update(Long id, PeliculaDTO peliculaDto) {
		
		Pelicula peliculaToUpdate = peliculaRepository.findById(id).get();
		
		if (peliculaDto.getIdCategoria() != null) {
			peliculaToUpdate.setIdCategoria(peliculaDto.getIdCategoria());
		}
		if (peliculaDto.getTitulo() != null) {
			peliculaToUpdate.setTitulo(peliculaDto.getTitulo());
		}
		if (peliculaDto.getEsta_disponible() != null) {
			peliculaToUpdate.setEsta_disponible(peliculaDto.getEsta_disponible());
		}

		return convertirToDto(peliculaRepository.save(peliculaToUpdate));
	}

	@Override
	public void deleteById(Long id) {
		peliculaRepository.deleteById(id);
	}


	private PeliculaDTO convertirToDto(Pelicula pelicula) {
		PeliculaDTO peliculaDto = modelMapper.map(pelicula, PeliculaDTO.class);
		return peliculaDto;
	}

	private Pelicula convertirToEntidad(PeliculaDTO peliculaDto) throws ParseException {
		Pelicula pelicula = modelMapper.map(peliculaDto, Pelicula.class);
		return pelicula;
	}


}
