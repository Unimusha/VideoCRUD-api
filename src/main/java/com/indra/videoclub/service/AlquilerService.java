package com.indra.videoclub.service;

import java.text.ParseException;
import java.util.List;

import com.indra.videoclub.dto.AlquilerDTO;

public interface AlquilerService {
	
	public abstract List<AlquilerDTO> findAll();

	public abstract AlquilerDTO findById(Long id);

	public abstract AlquilerDTO save(AlquilerDTO alquilerDto) throws ParseException;

	public abstract AlquilerDTO update(Long id, AlquilerDTO alquilerDto);

	public abstract void deleteById(Long id);


}
