package com.saludvida.farmacia.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.saludvida.farmacia.dominio.entidades.DetallePedido;
import com.saludvida.farmacia.dominio.repositorio.IDetallePedidoRepositorio;
import com.saludvida.farmacia.infraestructura.persistencia.mapeadores.IDetallePedidoJpaMapper;
import com.saludvida.farmacia.infraestructura.repositorios.IDetallePedidoJpaRepository;

@Repository
public final class DetallePedidoRepositorioImpl
        implements IDetallePedidoRepositorio {

    private final IDetallePedidoJpaRepository jpaRepository;
    private final IDetallePedidoJpaMapper mapper;

    public DetallePedidoRepositorioImpl(
            IDetallePedidoJpaRepository jpaRepository,
            IDetallePedidoJpaMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public DetallePedido guardar(DetallePedido detalle) {
        return mapper.toDomain(
                jpaRepository.save(mapper.toEntity(detalle)));
    }

    @Override
    public Optional<DetallePedido> buscarPorId(long id) {
        return jpaRepository.findById(Math.toIntExact(id))
                .map(mapper::toDomain);
    }

    @Override
    public List<DetallePedido> buscarPorPedido(long idPedido) {
        return jpaRepository
                .findByPedido_IdPedido(Math.toIntExact(idPedido))
                .stream().map(mapper::toDomain).toList();
    }

    @Override
    public List<DetallePedido> listarTodos() {
        return jpaRepository.findAll().stream()
                .map(mapper::toDomain).toList();
    }
}