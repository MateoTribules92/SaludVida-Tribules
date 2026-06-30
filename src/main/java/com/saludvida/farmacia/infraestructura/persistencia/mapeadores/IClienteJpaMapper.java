package com.saludvida.farmacia.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.saludvida.farmacia.dominio.entidades.Cliente;
import com.saludvida.farmacia.infraestructura.persistencia.jpa.ClienteJpa;

@Mapper(componentModel = "spring")
public interface IClienteJpaMapper {

    Cliente toDomain(ClienteJpa entity);

    ClienteJpa toEntity(Cliente domain);
}
