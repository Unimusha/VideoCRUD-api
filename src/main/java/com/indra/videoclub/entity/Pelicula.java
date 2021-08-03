package com.indra.videoclub.entity;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.indra.videoclub.entity.Categoria;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Table(name = "peliculas", schema = "videoclub")

public class Pelicula implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4360267777380254668L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pelicula")
	private Long idPelicula;

	@Column(name = "id_categoria", nullable = false)
	private Long idCategoria;

	@Column(name = "titulo", nullable = false)
	private String titulo;
	
	@Column(name = "descripcion", nullable = true)
	private String descripcion;
	
	@Column(name = "popularidad", nullable = true)
	private Double popularidad;
	
	@Column(name = "poster", nullable = true)
	private String poster;
	
	@Column(name = "esta_disponible", nullable = false)
	private boolean esta_disponible;
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_categoria", nullable = false, insertable = false, updatable = false)
	private Categoria categoria;
	

}