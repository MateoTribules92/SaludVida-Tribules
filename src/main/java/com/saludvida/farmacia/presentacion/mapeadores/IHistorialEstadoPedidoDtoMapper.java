package com.saludvida.farmacia.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.saludvida.farmacia.dominio.entidades.HistorialEstadoPedido;
import com.saludvida.farmacia.presentacion.dto.request.HistorialEstadoPedidoRequestDTO;
import com.saludvida.farmacia.presentacion.dto.response.HistorialEstadoPedidoResponseDTO;

@Mapper(componentModel = "spring")
public interface IHistorialEstadoPedidoDtoMapper {

    @Mapping(target = "idHistorial", expression = "java(0L)")
    @Mapping(target = "fechaRegistro", ignore = true)
    HistorialEstadoPedido toDomain(HistorialEstadoPedidoRequestDTO dto);

    @Mapping(target = "idHistorial", source = "id")
    @Mapping(target = "fechaRegistro", ignore = true)
    HistorialEstadoPedido toDomain(long id, HistorialEstadoPedidoRequestDTO dto);

    HistorialEstadoPedidoResponseDTO toResponse(HistorialEstadoPedido historialEstadoPedido);
}