package com.saludvida.farmacia.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.saludvida.farmacia.dominio.entidades.DetallePedido;
import com.saludvida.farmacia.presentacion.dto.request.DetallePedidoRequestDTO;
import com.saludvida.farmacia.presentacion.dto.response.DetallePedidoResponseDTO;

@Mapper(componentModel = "spring")
public interface IDetallePedidoDtoMapper {

    @Mapping(target = "idDetalle", expression = "java(0L)")
    DetallePedido toDomain(DetallePedidoRequestDTO dto);

    @Mapping(target = "idDetalle", source = "id")
    DetallePedido toDomain(long id, DetallePedidoRequestDTO dto);

    DetallePedidoResponseDTO toResponse(DetallePedido detallePedido);
}