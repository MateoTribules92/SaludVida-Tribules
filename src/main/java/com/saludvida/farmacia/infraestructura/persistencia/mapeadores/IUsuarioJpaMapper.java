package com.saludvida.farmacia.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.saludvida.farmacia.dominio.entidades.Usuario;
import com.saludvida.farmacia.infraestructura.persistencia.jpa.UsuarioJpa;

@Mapper(componentModel = "spring")
public interface IUsuarioJpaMapper {

    @Mapping(target = "idRol", source = "rol.idRol")
    Usuario toDomain(UsuarioJpa entity);

    @Mapping(target = "rol.idRol", source = "idRol")
    UsuarioJpa toEntity(Usuario domain);
}