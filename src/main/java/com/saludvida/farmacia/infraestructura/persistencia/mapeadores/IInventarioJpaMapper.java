package com.saludvida.farmacia.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.saludvida.farmacia.dominio.entidades.Inventario;
import com.saludvida.farmacia.infraestructura.persistencia.jpa.InventarioJpa;

@Mapper(componentModel = "spring")
public interface IInventarioJpaMapper {

    @Mapping(target = "idFarmacia", source = "farmacia.idFarmacia")
    @Mapping(target = "idProducto", source = "producto.idProducto")
    Inventario toDomain(InventarioJpa entity);

    @Mapping(target = "farmacia.idFarmacia", source = "idFarmacia")
    @Mapping(target = "producto.idProducto", source = "idProducto")
    InventarioJpa toEntity(Inventario domain);
}