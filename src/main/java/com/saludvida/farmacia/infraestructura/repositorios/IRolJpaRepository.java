package com.saludvida.farmacia.infraestructura.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saludvida.farmacia.infraestructura.persistencia.jpa.RolJpa;

public interface IRolJpaRepository extends JpaRepository<RolJpa, Integer> {
	 Optional<RolJpa> findByCodigo(String codigo);
	 
	 List<RolJpa> findAllByActivoTrue();
}