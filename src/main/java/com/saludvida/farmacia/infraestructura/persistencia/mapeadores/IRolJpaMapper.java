package com.saludvida.farmacia.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.saludvida.farmacia.dominio.entidades.Rol;
import com.saludvida.farmacia.infraestructura.persistencia.jpa.RolJpa;

@Mapper(componentModel = "spring")
public interface IRolJpaMapper {
	
	 Rol toDomain(RolJpa entity);

	 RolJpa toEntity(Rol domain);

}
