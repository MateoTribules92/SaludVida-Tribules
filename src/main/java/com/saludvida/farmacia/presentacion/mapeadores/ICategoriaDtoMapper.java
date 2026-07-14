package com.saludvida.farmacia.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.saludvida.farmacia.dominio.entidades.Categoria;
import com.saludvida.farmacia.presentacion.dto.request.CategoriaRequestDTO;
import com.saludvida.farmacia.presentacion.dto.response.CategoriaResponseDTO;

@Mapper(componentModel = "spring")
public interface ICategoriaDtoMapper {

    @Mapping(target = "idCategoria", expression = "java(0L)")
    Categoria toDomain(CategoriaRequestDTO dto);

    @Mapping(target = "idCategoria", source = "id")
    Categoria toDomain(long id, CategoriaRequestDTO dto);

    CategoriaResponseDTO toResponse(Categoria categoria);
}