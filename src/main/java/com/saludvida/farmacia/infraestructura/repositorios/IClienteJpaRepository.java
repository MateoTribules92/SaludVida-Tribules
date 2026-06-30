package com.saludvida.farmacia.infraestructura.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saludvida.farmacia.dominio.entidades.ClasificacionCliente;
import com.saludvida.farmacia.infraestructura.persistencia.jpa.ClienteJpa;

public interface IClienteJpaRepository
        extends JpaRepository<ClienteJpa, Integer> {

    Optional<ClienteJpa> findByIdentificacion(String identificacion);

    boolean existsByIdentificacion(String identificacion);

    List<ClienteJpa> findAllByActivoTrue();

    List<ClienteJpa> findByClasificacion(
            ClasificacionCliente clasificacion);
}
