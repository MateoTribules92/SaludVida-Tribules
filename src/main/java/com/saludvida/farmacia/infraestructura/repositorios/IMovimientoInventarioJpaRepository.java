package com.saludvida.farmacia.infraestructura.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saludvida.farmacia.dominio.entidades.TipoMovimiento;
import com.saludvida.farmacia.infraestructura.persistencia.jpa.MovimientoInventarioJpa;

public interface IMovimientoInventarioJpaRepository
        extends JpaRepository<MovimientoInventarioJpa, Integer> {

    List<MovimientoInventarioJpa>
        findByInventario_IdInventarioOrderByFechaMovimientoDesc(
            Integer idInventario);

    List<MovimientoInventarioJpa>
        findByUsuario_IdUsuarioOrderByFechaMovimientoDesc(
            Integer idUsuario);
    
    List<MovimientoInventarioJpa> findByUsuario_IdUsuario(Integer idUsuario);

    List<MovimientoInventarioJpa> findByTipoMovimiento(TipoMovimiento tipoMovimiento);
}