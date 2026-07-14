package com.saludvida.farmacia.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.saludvida.farmacia.dominio.entidades.Usuario;
import com.saludvida.farmacia.presentacion.dto.request.UsuarioRequestDTO;
import com.saludvida.farmacia.presentacion.dto.response.UsuarioResponseDTO;

@Mapper(componentModel = "spring")
public interface IUsuarioDtoMapper {

	@Mapping(target = "idUsuario", expression = "java(0L)")
    @Mapping(target = "fechaCreacion", ignore = true)
    @Mapping(target = "fechaActualizacion", ignore = true)
    Usuario toDomain(UsuarioRequestDTO dto);

    @Mapping(target = "idUsuario", source = "id")
    @Mapping(target = "fechaCreacion", ignore = true)
    @Mapping(target = "fechaActualizacion", ignore = true)
    Usuario toDomain(long id, UsuarioRequestDTO dto);

    UsuarioResponseDTO toResponse(Usuario usuario);
}