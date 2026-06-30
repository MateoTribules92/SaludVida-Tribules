package com.saludvida.farmacia.infraestructura.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saludvida.farmacia.infraestructura.persistencia.jpa.FarmaciaJpa;

public interface IFarmaciaJpaRepository
        extends JpaRepository<FarmaciaJpa, Integer> {

    List<FarmaciaJpa> findByCiudadIgnoreCase(String ciudad);

    List<FarmaciaJpa> findByZonaIgnoreCase(String zona);

    List<FarmaciaJpa> findAllByActivoTrue();
}