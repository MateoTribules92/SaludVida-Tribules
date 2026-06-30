package com.saludvida.farmacia.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.saludvida.farmacia.dominio.entidades.Categoria;
import com.saludvida.farmacia.infraestructura.persistencia.jpa.CategoriaJpa;

@Mapper(componentModel = "spring")
public interface ICategoriaJpaMapper {

    Categoria toDomain(CategoriaJpa entity);

    CategoriaJpa toEntity(Categoria domain);
}