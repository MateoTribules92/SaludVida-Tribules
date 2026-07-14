package com.saludvida.farmacia.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.saludvida.farmacia.dominio.entidades.Cliente;
import com.saludvida.farmacia.presentacion.dto.request.ClienteRequestDTO;
import com.saludvida.farmacia.presentacion.dto.response.ClienteResponseDTO;

@Mapper(componentModel = "spring")
public interface IClienteDtoMapper {

    @Mapping(target = "idCliente", expression = "java(0L)")
    @Mapping(target = "fechaCreacion", ignore = true)
    @Mapping(target = "fechaActualizacion", ignore = true)
    Cliente toDomain(ClienteRequestDTO dto);

    @Mapping(target = "idCliente", source = "id")
    @Mapping(target = "fechaCreacion", ignore = true)
    @Mapping(target = "fechaActualizacion", ignore = true)
    Cliente toDomain(long id, ClienteRequestDTO dto);

    ClienteResponseDTO toResponse(Cliente cliente);
}
