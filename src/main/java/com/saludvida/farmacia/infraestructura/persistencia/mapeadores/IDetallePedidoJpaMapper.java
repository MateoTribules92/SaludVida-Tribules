package com.saludvida.farmacia.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.saludvida.farmacia.dominio.entidades.DetallePedido;
import com.saludvida.farmacia.infraestructura.persistencia.jpa.DetallePedidoJpa;

@Mapper(componentModel = "spring")
public interface IDetallePedidoJpaMapper {

    @Mapping(target = "idPedido", source = "pedido.idPedido")
    @Mapping(target = "idProducto", source = "producto.idProducto")
    DetallePedido toDomain(DetallePedidoJpa entity);

    @Mapping(target = "pedido.idPedido", source = "idPedido")
    @Mapping(target = "producto.idProducto", source = "idProducto")
    DetallePedidoJpa toEntity(DetallePedido domain);
}