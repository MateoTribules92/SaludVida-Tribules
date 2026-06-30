package com.saludvida.farmacia.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.saludvida.farmacia.dominio.entidades.Ruta;
import com.saludvida.farmacia.infraestructura.persistencia.jpa.RutaJpa;

@Mapper(componentModel = "spring")
public interface IRutaJpaMapper {

    @Mapping(target = "idVehiculo", source = "vehiculo.idVehiculo")
    @Mapping(target = "idDistribuidor", source = "distribuidor.idUsuario")
    Ruta toDomain(RutaJpa entity);

    @Mapping(target = "vehiculo.idVehiculo", source = "idVehiculo")
    @Mapping(target = "distribuidor.idUsuario", source = "idDistribuidor")
    RutaJpa toEntity(Ruta domain);
}