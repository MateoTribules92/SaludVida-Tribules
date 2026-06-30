package com.saludvida.farmacia.infraestructura.persistencia.mapeadores;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.saludvida.farmacia.dominio.entidades.MovimientoInventario;
import com.saludvida.farmacia.infraestructura.persistencia.jpa.MovimientoInventarioJpa;

@Mapper(componentModel = "spring")
public interface IMovimientoInventarioJpaMapper {

    @Mapping(target = "idInventario", source = "inventario.idInventario")
    @Mapping(target = "idUsuario", source = "usuario.idUsuario")
    MovimientoInventario toDomain(MovimientoInventarioJpa entity);

    @Mapping(target = "inventario.idInventario", source = "idInventario")
    @Mapping(target = "usuario.idUsuario", source = "idUsuario")
    MovimientoInventarioJpa toEntity(MovimientoInventario domain);
}