package com.saludvida.farmacia.infraestructura.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saludvida.farmacia.dominio.entidades.EstadoVehiculo;
import com.saludvida.farmacia.infraestructura.persistencia.jpa.VehiculoJpa;

public interface IVehiculoJpaRepository
        extends JpaRepository<VehiculoJpa, Integer> {

    Optional<VehiculoJpa> findByPlaca(String placa);

    boolean existsByPlaca(String placa);

    List<VehiculoJpa> findAllByActivoTrue();

    List<VehiculoJpa> findByEstadoAndActivoTrue(
            EstadoVehiculo estado);
}