package com.saludvida.farmacia.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.saludvida.farmacia.dominio.entidades.RutaPedido;
import com.saludvida.farmacia.presentacion.dto.request.RutaPedidoRequestDTO;
import com.saludvida.farmacia.presentacion.dto.response.RutaPedidoResponseDTO;

@Mapper(componentModel = "spring")
public interface IRutaPedidoDtoMapper {

    @Mapping(target = "idRutaPedido", expression = "java(0L)")
    @Mapping(target = "fechaAsignacion", ignore = true)
    RutaPedido toDomain(RutaPedidoRequestDTO dto);

    @Mapping(target = "idRutaPedido", source = "id")
    @Mapping(target = "fechaAsignacion", ignore = true)
    RutaPedido toDomain(long id, RutaPedidoRequestDTO dto);

    RutaPedidoResponseDTO toResponse(RutaPedido rutaPedido);
}
