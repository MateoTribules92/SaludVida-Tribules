package com.saludvida.farmacia.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.saludvida.farmacia.dominio.entidades.Pedido;
import com.saludvida.farmacia.infraestructura.persistencia.jpa.PedidoJpa;

@Mapper(componentModel = "spring")
public interface IPedidoJpaMapper {

    @Mapping(target = "idCliente", source = "cliente.idCliente")
    @Mapping(target = "idFarmacia", source = "farmacia.idFarmacia")
    @Mapping(target = "idVendedor", source = "vendedor.idUsuario")
    Pedido toDomain(PedidoJpa entity);

    @Mapping(target = "cliente.idCliente", source = "idCliente")
    @Mapping(target = "farmacia.idFarmacia", source = "idFarmacia")
    @Mapping(target = "vendedor.idUsuario", source = "idVendedor")
    PedidoJpa toEntity(Pedido domain);
}