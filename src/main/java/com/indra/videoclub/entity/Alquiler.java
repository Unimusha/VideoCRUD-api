
package com.indra.videoclub.entity;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "alquileres", schema = "videoclub")
public class Alquiler implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3784234935761654942L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_alquiler")
	private Long idAlquiler;

	@Column(name = "id_usuario", nullable = false)
	private Long idUsuario;

	@Column(name = "id_pelicula", nullable = false)
	private Long idPelicula;
	
	@Column(name = "esta_alquilada", nullable = false)
	private Boolean esta_alquilada;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "id_usuario", nullable = false, insertable = false, updatable = false)
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "id_pelicula", nullable = false, insertable = false, updatable = false)
	private Pelicula pelicula;

}