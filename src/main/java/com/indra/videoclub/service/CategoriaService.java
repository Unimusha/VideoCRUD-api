package com.indra.videoclub.service;

import java.text.ParseException;
import java.util.List;

import com.indra.videoclub.dto.CategoriaDTO;

public interface CategoriaService {
	
	public abstract List<CategoriaDTO> findAll();

	public abstract CategoriaDTO findById(Long id);

	public abstract CategoriaDTO save(CategoriaDTO peliculaDto) throws ParseException;

	public abstract CategoriaDTO update(Long id, CategoriaDTO peliculaDto);

	public abstract void deleteById(Long id);


}
