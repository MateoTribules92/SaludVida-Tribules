package com.saludvida.farmacia.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.saludvida.farmacia.dominio.entidades.Farmacia;
import com.saludvida.farmacia.infraestructura.persistencia.jpa.FarmaciaJpa;

@Mapper(componentModel = "spring")
public interface IFarmaciaJpaMapper {

    Farmacia toDomain(FarmaciaJpa entity);

    FarmaciaJpa toEntity(Farmacia domain);
}