package com.indra.videoclub.service;

import java.text.ParseException;
import java.util.List;

import com.indra.videoclub.dto.PeliculaDTO;

public interface PeliculaService {
	
	public abstract List<PeliculaDTO> findAll();

	public abstract PeliculaDTO findById(Long id);

	public abstract PeliculaDTO save(PeliculaDTO peliculaDto) throws ParseException;

	public abstract PeliculaDTO update(Long id, PeliculaDTO peliculaDto);

	public abstract void deleteById(Long id);


}
