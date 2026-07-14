package com.saludvida.farmacia.infraestructura.repositorios;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saludvida.farmacia.infraestructura.persistencia.jpa.ProductoJpa;

public interface IProductoJpaRepository
        extends JpaRepository<ProductoJpa, Integer> {

    Optional<ProductoJpa> findByCodigo(String codigo);

    boolean existsByCodigo(String codigo);

    List<ProductoJpa> findAllByActivoTrue();

    List<ProductoJpa> findByCategoria_IdCategoria(Integer idCategoria);

    List<ProductoJpa> findByProveedor_IdProveedor(Integer idProveedor);

    List<ProductoJpa> findByFechaCaducidadBefore(LocalDate fecha);

    List<ProductoJpa> findByFechaCaducidadBetween(
            LocalDate fechaInicial,
            LocalDate fechaFinal);
    
    
}
