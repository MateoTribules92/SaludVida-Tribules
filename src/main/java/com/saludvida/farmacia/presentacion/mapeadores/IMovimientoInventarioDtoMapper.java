package com.saludvida.farmacia.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.saludvida.farmacia.dominio.entidades.MovimientoInventario;
import com.saludvida.farmacia.presentacion.dto.request.MovimientoInventarioRequestDTO;
import com.saludvida.farmacia.presentacion.dto.response.MovimientoInventarioResponseDTO;

@Mapper(componentModel = "spring")
public interface IMovimientoInventarioDtoMapper {

    @Mapping(target = "idMovimiento", expression = "java(0L)")
    @Mapping(target = "fechaMovimiento", ignore = true)
    MovimientoInventario toDomain(MovimientoInventarioRequestDTO dto);

    @Mapping(target = "idMovimiento", source = "id")
    @Mapping(target = "fechaMovimiento", ignore = true)
    MovimientoInventario toDomain(long id, MovimientoInventarioRequestDTO dto);

    MovimientoInventarioResponseDTO toResponse(MovimientoInventario movimientoInventario);
}