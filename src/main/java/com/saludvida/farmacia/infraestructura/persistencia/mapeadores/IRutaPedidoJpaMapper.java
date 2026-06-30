package com.saludvida.farmacia.infraestructura.persistencia.mapeadores;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.saludvida.farmacia.dominio.entidades.RutaPedido;
import com.saludvida.farmacia.infraestructura.persistencia.jpa.RutaPedidoJpa;

@Mapper(componentModel = "spring")
public interface IRutaPedidoJpaMapper {

    @Mapping(target = "idRuta", source = "ruta.idRuta")
    @Mapping(target = "idPedido", source = "pedido.idPedido")
    RutaPedido toDomain(RutaPedidoJpa entity);

    @Mapping(target = "ruta.idRuta", source = "idRuta")
    @Mapping(target = "pedido.idPedido", source = "idPedido")
    RutaPedidoJpa toEntity(RutaPedido domain);
}