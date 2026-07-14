package com.saludvida.farmacia.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.saludvida.farmacia.dominio.entidades.Producto;
import com.saludvida.farmacia.presentacion.dto.request.ProductoRequestDTO;
import com.saludvida.farmacia.presentacion.dto.response.ProductoResponseDTO;

@Mapper(componentModel = "spring")
public interface IProductoDtoMapper {

    @Mapping(target = "idProducto", expression = "java(0L)")
    @Mapping(target = "fechaCreacion", ignore = true)
    @Mapping(target = "fechaActualizacion", ignore = true)
    Producto toDomain(ProductoRequestDTO dto);

    @Mapping(target = "idProducto", source = "id")
    @Mapping(target = "fechaCreacion", ignore = true)
    @Mapping(target = "fechaActualizacion", ignore = true)
    Producto toDomain(long id, ProductoRequestDTO dto);

    ProductoResponseDTO toResponse(Producto producto);
}