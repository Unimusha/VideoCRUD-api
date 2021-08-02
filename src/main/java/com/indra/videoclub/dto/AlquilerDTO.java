package com.indra.videoclub.dto;


import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Este modelo representa a los alquileres")
public class AlquilerDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7243010060110977216L;

	@ApiModelProperty(required = false, position = 1, value = "99999")
	@JsonProperty("id_alquiler")
	private Long idAlquiler;

	@ApiModelProperty(required = true, position = 2, value = "99999")
	@JsonProperty("id_usuario")
	private Long idUsuario;

	@ApiModelProperty(required = true, position = 3, value = "99999")
	@JsonProperty("id_pelicula")
	private Long idPelicula;

	@ApiModelProperty(required = false, position = 4, value = "0")
	@JsonProperty("esta_alquilada")
	private Boolean esta_alquilada;
	
	@ApiModelProperty(required = false, position = 5)
	@JsonProperty("usuario")
	@JsonBackReference
	private UsuarioDTO usuario;

	@ApiModelProperty(required = false, position = 6)
	@JsonProperty("pelicula")
	private PeliculaDTO pelicula;

}