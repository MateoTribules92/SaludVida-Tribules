package com.saludvida.farmacia.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.saludvida.farmacia.dominio.entidades.Rol;
import com.saludvida.farmacia.presentacion.dto.request.RolRequestDTO;
import com.saludvida.farmacia.presentacion.dto.response.RolResponseDTO;

@Mapper(componentModel = "spring")
public interface IRolDtoMapper {

	 @Mapping(target = "idRol", expression = "java(0L)")
	    Rol toDomain(RolRequestDTO dto);
	 
    @Mapping(target = "idRol", source = "id")
    Rol toDomain(long id, RolRequestDTO dto);

    RolResponseDTO toResponse(Rol rol);
}