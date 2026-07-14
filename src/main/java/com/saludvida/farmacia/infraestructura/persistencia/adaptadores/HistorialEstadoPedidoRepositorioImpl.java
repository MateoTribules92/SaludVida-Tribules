package com.saludvida.farmacia.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.saludvida.farmacia.dominio.entidades.HistorialEstadoPedido;
import com.saludvida.farmacia.dominio.repositorio.IHistorialEstadoPedidoRepositorio;
import com.saludvida.farmacia.infraestructura.persistencia.mapeadores.IHistorialEstadoPedidoJpaMapper;
import com.saludvida.farmacia.infraestructura.repositorios.IHistorialEstadoPedidoJpaRepository;

@Repository
public final class HistorialEstadoPedidoRepositorioImpl
        implements IHistorialEstadoPedidoRepositorio {

    private final IHistorialEstadoPedidoJpaRepository jpaRepository;
    private final IHistorialEstadoPedidoJpaMapper mapper;

    public HistorialEstadoPedidoRepositorioImpl(
            IHistorialEstadoPedidoJpaRepository jpaRepository,
            IHistorialEstadoPedidoJpaMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public HistorialEstadoPedido guardar(
            HistorialEstadoPedido historial) {
        return mapper.toDomain(
                jpaRepository.save(mapper.toEntity(historial)));
    }

    @Override
    public Optional<HistorialEstadoPedido> buscarPorId(long id) {
        return jpaRepository.findById(Math.toIntExact(id))
                .map(mapper::toDomain);
    }

    @Override
    public List<HistorialEstadoPedido> buscarPorPedido(long idPedido) {
        return jpaRepository
                .findByPedido_IdPedidoOrderByFechaRegistroAsc(
                    Math.toIntExact(idPedido))
                .stream().map(mapper::toDomain).toList();
    }

    @Override
    public List<HistorialEstadoPedido> listarTodos() {
        return jpaRepository.findAll().stream()
                .map(mapper::toDomain).toList();
    }
    
    @Override
    public List<HistorialEstadoPedido> buscarPorUsuario(long idUsuario) {
        return jpaRepository.findByUsuario_IdUsuario(Math.toIntExact(idUsuario))
                .stream()
                .map(mapper::toDomain)
                .toList();
    }
}