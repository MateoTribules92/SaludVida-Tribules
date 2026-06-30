package com.saludvida.farmacia.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.saludvida.farmacia.dominio.entidades.HistorialEstadoPedido;
import com.saludvida.farmacia.infraestructura.persistencia.jpa.HistorialEstadoPedidoJpa;

@Mapper(componentModel = "spring")
public interface IHistorialEstadoPedidoJpaMapper {

    @Mapping(target = "idPedido", source = "pedido.idPedido")
    @Mapping(target = "idUsuario", source = "usuario.idUsuario")
    HistorialEstadoPedido toDomain(HistorialEstadoPedidoJpa entity);

    @Mapping(target = "pedido.idPedido", source = "idPedido")
    @Mapping(target = "usuario.idUsuario", source = "idUsuario")
    HistorialEstadoPedidoJpa toEntity(HistorialEstadoPedido domain);
}