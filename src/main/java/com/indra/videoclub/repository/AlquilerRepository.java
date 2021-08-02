package com.indra.videoclub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.indra.videoclub.entity.Alquiler;


@Repository
public interface AlquilerRepository extends JpaRepository<Alquiler, Long> {
	

}