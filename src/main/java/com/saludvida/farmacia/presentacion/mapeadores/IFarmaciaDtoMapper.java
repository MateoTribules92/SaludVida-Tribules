package com.saludvida.farmacia.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.saludvida.farmacia.dominio.entidades.Farmacia;
import com.saludvida.farmacia.presentacion.dto.request.FarmaciaRequestDTO;
import com.saludvida.farmacia.presentacion.dto.response.FarmaciaResponseDTO;

@Mapper(componentModel = "spring")
public interface IFarmaciaDtoMapper {

    @Mapping(target = "idFarmacia", expression = "java(0L)")
    Farmacia toDomain(FarmaciaRequestDTO dto);

    @Mapping(target = "idFarmacia", source = "id")
    Farmacia toDomain(long id, FarmaciaRequestDTO dto);

    FarmaciaResponseDTO toResponse(Farmacia farmacia);
}
