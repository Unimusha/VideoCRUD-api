package com.indra.videoclub.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.indra.videoclub.dto.CategoriaDTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(description = "Este modelo representa a las Peliculas")
@JsonInclude(JsonInclude.Include.NON_NULL)

public class PeliculaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1811780179407257852L;

	@ApiModelProperty(required = false, position = 1, value = "99999")
	@JsonProperty("id_usuario")
	private Long idUsuario;

	@ApiModelProperty(required = true, position = 2, example = "99999")
	@JsonProperty("id_categoria")
	private Long idCategoria;

	@ApiModelProperty(required = true, position = 3, example = "TituloDeEjemplo")
	@JsonProperty("titulo")
	private String titulo;
	
	@ApiModelProperty(required = true, position = 4, example = "DecrpicionDeEjemplo")
	@JsonProperty("descripcion")
	private String descripcion;
	
	@ApiModelProperty(required = true, position = 5, example = "8.5")
	@JsonProperty("popularidad")
	private Double popularidad;
	
	@ApiModelProperty(required = true, position = 6, example = "/urlPoster")
	@JsonProperty("poster")
	private String poster;

	@ApiModelProperty(required = true, position = 7, example = "0")
	@JsonProperty("esta_disponible")
	private Boolean esta_disponible;

	@ApiModelProperty(required = false, position = 8)
	@JsonProperty("categoria")
	@JsonBackReference
	private CategoriaDTO categoria;
}