package com.saludvida.farmacia.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.saludvida.farmacia.dominio.entidades.MovimientoInventario;
import com.saludvida.farmacia.dominio.entidades.TipoMovimiento;
import com.saludvida.farmacia.dominio.repositorio.IMovimientoInventarioRepositorio;
import com.saludvida.farmacia.infraestructura.persistencia.mapeadores.IMovimientoInventarioJpaMapper;
import com.saludvida.farmacia.infraestructura.repositorios.IMovimientoInventarioJpaRepository;

@Repository
public final class MovimientoInventarioRepositorioImpl
        implements IMovimientoInventarioRepositorio {

    private final IMovimientoInventarioJpaRepository jpaRepository;
    private final IMovimientoInventarioJpaMapper mapper;

    public MovimientoInventarioRepositorioImpl(
            IMovimientoInventarioJpaRepository jpaRepository,
            IMovimientoInventarioJpaMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public MovimientoInventario guardar(
            MovimientoInventario movimiento) {
        return mapper.toDomain(
                jpaRepository.save(mapper.toEntity(movimiento)));
    }

    @Override
    public Optional<MovimientoInventario> buscarPorId(long id) {
        return jpaRepository.findById(Math.toIntExact(id))
                .map(mapper::toDomain);
    }

    @Override
    public List<MovimientoInventario> buscarPorInventario(
            long idInventario) {
        return jpaRepository
                .findByInventario_IdInventarioOrderByFechaMovimientoDesc(
                    Math.toIntExact(idInventario))
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public List<MovimientoInventario> listarTodos() {
        return jpaRepository.findAll().stream()
                .map(mapper::toDomain).toList();
    }
    
    @Override
    public List<MovimientoInventario> buscarPorUsuario(long idUsuario) {
        return jpaRepository.findByUsuario_IdUsuario(Math.toIntExact(idUsuario))
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public List<MovimientoInventario> buscarPorTipoMovimiento(TipoMovimiento tipoMovimiento) {
        return jpaRepository.findByTipoMovimiento(tipoMovimiento)
                .stream()
                .map(mapper::toDomain)
                .toList();
    }
}