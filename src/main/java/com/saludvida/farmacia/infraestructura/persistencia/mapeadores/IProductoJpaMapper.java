package com.saludvida.farmacia.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.saludvida.farmacia.dominio.entidades.Producto;
import com.saludvida.farmacia.infraestructura.persistencia.jpa.ProductoJpa;

@Mapper(componentModel = "spring")
public interface IProductoJpaMapper {

    @Mapping(target = "idCategoria", source = "categoria.idCategoria")
    @Mapping(target = "idProveedor", source = "proveedor.idProveedor")
    Producto toDomain(ProductoJpa entity);

    @Mapping(target = "categoria.idCategoria", source = "idCategoria")
    @Mapping(target = "proveedor.idProveedor", source = "idProveedor")
    ProductoJpa toEntity(Producto domain);
}