package com.saludvida.farmacia.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.saludvida.farmacia.dominio.entidades.Vehiculo;
import com.saludvida.farmacia.infraestructura.persistencia.jpa.VehiculoJpa;

@Mapper(componentModel = "spring")
public interface IVehiculoJpaMapper {

    Vehiculo toDomain(VehiculoJpa entity);

    VehiculoJpa toEntity(Vehiculo domain);
}