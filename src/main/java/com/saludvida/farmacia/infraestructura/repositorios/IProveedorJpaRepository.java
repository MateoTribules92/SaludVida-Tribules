package com.saludvida.farmacia.infraestructura.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saludvida.farmacia.infraestructura.persistencia.jpa.ProveedorJpa;

public interface IProveedorJpaRepository
        extends JpaRepository<ProveedorJpa, Integer> {

    Optional<ProveedorJpa> findByRuc(String ruc);

    boolean existsByRuc(String ruc);

    List<ProveedorJpa> findAllByActivoTrue();
}
