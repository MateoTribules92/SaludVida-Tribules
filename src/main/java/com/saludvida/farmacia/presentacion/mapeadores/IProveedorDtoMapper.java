package com.saludvida.farmacia.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.saludvida.farmacia.dominio.entidades.Proveedor;
import com.saludvida.farmacia.presentacion.dto.request.ProveedorRequestDTO;
import com.saludvida.farmacia.presentacion.dto.response.ProveedorResponseDTO;

@Mapper(componentModel = "spring")
public interface IProveedorDtoMapper {

    @Mapping(target = "idProveedor", expression = "java(0L)")
    Proveedor toDomain(ProveedorRequestDTO dto);

    @Mapping(target = "idProveedor", source = "id")
    Proveedor toDomain(long id, ProveedorRequestDTO dto);

    ProveedorResponseDTO toResponse(Proveedor proveedor);
}