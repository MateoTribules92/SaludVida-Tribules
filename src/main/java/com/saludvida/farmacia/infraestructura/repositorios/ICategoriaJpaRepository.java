package com.saludvida.farmacia.infraestructura.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saludvida.farmacia.infraestructura.persistencia.jpa.CategoriaJpa;

public interface ICategoriaJpaRepository
        extends JpaRepository<CategoriaJpa, Integer> {

    Optional<CategoriaJpa> findByNombreIgnoreCase(String nombre);

    boolean existsByNombreIgnoreCase(String nombre);

    List<CategoriaJpa> findAllByActivoTrue();
}