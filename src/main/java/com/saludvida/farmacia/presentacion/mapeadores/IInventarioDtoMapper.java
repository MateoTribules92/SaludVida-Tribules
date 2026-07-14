package com.saludvida.farmacia.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.saludvida.farmacia.dominio.entidades.Inventario;
import com.saludvida.farmacia.presentacion.dto.request.InventarioRequestDTO;
import com.saludvida.farmacia.presentacion.dto.response.InventarioResponseDTO;

@Mapper(componentModel = "spring")
public interface IInventarioDtoMapper {

    @Mapping(target = "idInventario", expression = "java(0L)")
    @Mapping(target = "fechaActualizacion", ignore = true)
    Inventario toDomain(InventarioRequestDTO dto);

    @Mapping(target = "idInventario", source = "id")
    @Mapping(target = "fechaActualizacion", ignore = true)
    Inventario toDomain(long id, InventarioRequestDTO dto);

    InventarioResponseDTO toResponse(Inventario inventario);
}