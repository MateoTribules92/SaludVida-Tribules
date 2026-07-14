package com.saludvida.farmacia.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.saludvida.farmacia.dominio.entidades.Ruta;
import com.saludvida.farmacia.presentacion.dto.request.RutaRequestDTO;
import com.saludvida.farmacia.presentacion.dto.response.RutaResponseDTO;

@Mapper(componentModel = "spring")
public interface IRutaDtoMapper {

    @Mapping(target = "idRuta", expression = "java(0L)")
    @Mapping(target = "fechaCreacion", ignore = true)
    @Mapping(target = "fechaActualizacion", ignore = true)
    Ruta toDomain(RutaRequestDTO dto);

    @Mapping(target = "idRuta", source = "id")
    @Mapping(target = "fechaCreacion", ignore = true)
    @Mapping(target = "fechaActualizacion", ignore = true)
    Ruta toDomain(long id, RutaRequestDTO dto);

    RutaResponseDTO toResponse(Ruta ruta);
}
