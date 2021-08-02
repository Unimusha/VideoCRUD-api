package com.indra.videoclub.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.indra.videoclub.dto.AlquilerDTO;

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
@ApiModel(description = "Este modelo representa a los Usuarios")
@JsonInclude(JsonInclude.Include.NON_NULL)

public class UsuarioDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1811780179407257852L;

	@ApiModelProperty(required = false, position = 1, value = "99999")
	@JsonProperty("id_usuario")
	private Long idUsuario;

	@ApiModelProperty(required = true, position = 2, example = "nombreDeEjemplo")
	@JsonProperty("nombre")
	private String nombre;

	@ApiModelProperty(required = true, position = 3, example = "apellidoDeEjemplo")
	@JsonProperty("apellidos")
	private String apellidos;

	@ApiModelProperty(required = true, position = 4, example = "699699699")
	@JsonProperty("telefono")
	private String telefono;

	@ApiModelProperty(required = true, position = 5, example = "48730154X")
	@JsonProperty("dnie")
	private String dnie;
	
	@ApiModelProperty(required = false, position = 6)
	@JsonProperty("alquiler")
	@JsonManagedReference
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@Builder.Default
	private Set<AlquilerDTO> alquiler = new HashSet<>();

}