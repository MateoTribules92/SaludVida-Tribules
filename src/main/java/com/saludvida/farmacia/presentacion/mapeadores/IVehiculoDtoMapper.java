package com.saludvida.farmacia.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.saludvida.farmacia.dominio.entidades.Vehiculo;
import com.saludvida.farmacia.presentacion.dto.request.VehiculoRequestDTO;
import com.saludvida.farmacia.presentacion.dto.response.VehiculoResponseDTO;

@Mapper(componentModel = "spring")
public interface IVehiculoDtoMapper {

    @Mapping(target = "idVehiculo", expression = "java(0L)")
    Vehiculo toDomain(VehiculoRequestDTO dto);

    @Mapping(target = "idVehiculo", source = "id")
    Vehiculo toDomain(long id, VehiculoRequestDTO dto);

    VehiculoResponseDTO toResponse(Vehiculo vehiculo);
}
