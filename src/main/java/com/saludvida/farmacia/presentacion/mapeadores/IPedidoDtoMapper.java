package com.saludvida.farmacia.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.saludvida.farmacia.dominio.entidades.Pedido;
import com.saludvida.farmacia.presentacion.dto.request.PedidoRequestDTO;
import com.saludvida.farmacia.presentacion.dto.response.PedidoResponseDTO;

@Mapper(componentModel = "spring")
public interface IPedidoDtoMapper {

    @Mapping(target = "idPedido", expression = "java(0L)")
    @Mapping(target = "fechaPedido", ignore = true)
    @Mapping(target = "fechaActualizacion", ignore = true)
    Pedido toDomain(PedidoRequestDTO dto);

    @Mapping(target = "idPedido", source = "id")
    @Mapping(target = "fechaPedido", ignore = true)
    @Mapping(target = "fechaActualizacion", ignore = true)
    Pedido toDomain(long id, PedidoRequestDTO dto);

    PedidoResponseDTO toResponse(Pedido pedido);
}