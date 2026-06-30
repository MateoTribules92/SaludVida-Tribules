package com.saludvida.farmacia.infraestructura.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saludvida.farmacia.infraestructura.persistencia.jpa.UsuarioJpa;

public interface IUsuarioJpaRepository extends JpaRepository<UsuarioJpa, Integer> {

    Optional<UsuarioJpa> findByCorreo(String correo);

    boolean existsByCorreo(String correo);

    List<UsuarioJpa> findAllByActivoTrue();

    List<UsuarioJpa> findByRol_IdRol(Integer idRol);
}
