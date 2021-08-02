package com.indra.videoclub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.indra.videoclub.entity.Pelicula;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {
	


}