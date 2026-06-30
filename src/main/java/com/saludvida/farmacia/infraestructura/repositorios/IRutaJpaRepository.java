package com.saludvida.farmacia.infraestructura.repositorios;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saludvida.farmacia.dominio.entidades.EstadoRuta;
import com.saludvida.farmacia.infraestructura.persistencia.jpa.RutaJpa;

public interface IRutaJpaRepository
        extends JpaRepository<RutaJpa, Integer> {

    Optional<RutaJpa> findByCodigoRuta(String codigoRuta);

    boolean existsByCodigoRuta(String codigoRuta);

    List<RutaJpa> findByFechaRuta(LocalDate fechaRuta);

    List<RutaJpa> findByEstado(EstadoRuta estado);

    List<RutaJpa> findByZonaIgnoreCase(String zona);

    boolean existsByDistribuidor_IdUsuarioAndFechaRutaAndEstadoNotIn(
            Integer idDistribuidor,
            LocalDate fechaRuta,
            Collection<EstadoRuta> estados);

    boolean existsByVehiculo_IdVehiculoAndFechaRutaAndEstadoNotIn(
            Integer idVehiculo,
            LocalDate fechaRuta,
            Collection<EstadoRuta> estados);
}