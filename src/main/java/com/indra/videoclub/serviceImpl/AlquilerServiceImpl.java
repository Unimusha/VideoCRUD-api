package com.indra.videoclub.serviceImpl;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.indra.videoclub.dto.AlquilerDTO;
import com.indra.videoclub.entity.Alquiler;
import com.indra.videoclub.repository.AlquilerRepository;
import com.indra.videoclub.service.AlquilerService;



@Service
public class AlquilerServiceImpl implements AlquilerService {
	@Autowired
	private AlquilerRepository alquilerRepository;
	@Autowired
	ModelMapper modelMapper;

	@Override
	public List<AlquilerDTO> findAll() {
		
		List<Alquiler> alquiler = alquilerRepository.findAll();
		alquilerRepository.findAll();
		return alquiler.stream().map(this::convertirToDto).collect(Collectors.toList());
	}

	@Override
	public AlquilerDTO findById(Long id) {
		return convertirToDto(alquilerRepository.findById(id).get());
	}

	@Override
	public AlquilerDTO save(AlquilerDTO alquilerDto) throws ParseException {

		return convertirToDto(alquilerRepository.save(convertirToEntidad(alquilerDto)));
	}

	@Override
	public AlquilerDTO update(Long id, AlquilerDTO alquilerDto) {
		
		Alquiler alquilerToUpdate = alquilerRepository.findById(id).get();
		
		
		if (alquilerDto.getEsta_alquilada() != null) {
			alquilerToUpdate.setEsta_alquilada(alquilerDto.getEsta_alquilada());
		}


		return convertirToDto(alquilerRepository.save(alquilerToUpdate));
	}

	@Override
	public void deleteById(Long id) {
		alquilerRepository.deleteById(id);
	}


	private AlquilerDTO convertirToDto(Alquiler alquiler) {
		AlquilerDTO alquilerDto = modelMapper.map(alquiler, AlquilerDTO.class);
		return alquilerDto;
	}

	private Alquiler convertirToEntidad(AlquilerDTO alquilerDto) throws ParseException {
		Alquiler alquiler = modelMapper.map(alquilerDto, Alquiler.class);
		return alquiler;
	}



}
