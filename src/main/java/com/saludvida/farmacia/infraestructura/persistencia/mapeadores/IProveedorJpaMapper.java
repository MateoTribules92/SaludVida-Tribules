package com.saludvida.farmacia.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.saludvida.farmacia.dominio.entidades.Proveedor;
import com.saludvida.farmacia.infraestructura.persistencia.jpa.ProveedorJpa;

@Mapper(componentModel = "spring")
public interface IProveedorJpaMapper {

    Proveedor toDomain(ProveedorJpa entity);

    ProveedorJpa toEntity(Proveedor domain);
}
