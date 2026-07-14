package com.saludvida.farmacia.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.saludvida.farmacia.dominio.entidades.RutaPedido;
import com.saludvida.farmacia.dominio.repositorio.IRutaPedidoRepositorio;
import com.saludvida.farmacia.infraestructura.persistencia.mapeadores.IRutaPedidoJpaMapper;
import com.saludvida.farmacia.infraestructura.repositorios.IRutaPedidoJpaRepository;

@Repository
public final class RutaPedidoRepositorioImpl
        implements IRutaPedidoRepositorio {

    private final IRutaPedidoJpaRepository jpaRepository;
    private final IRutaPedidoJpaMapper mapper;

    public RutaPedidoRepositorioImpl(
            IRutaPedidoJpaRepository jpaRepository,
            IRutaPedidoJpaMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public RutaPedido guardar(RutaPedido rutaPedido) {
        return mapper.toDomain(
                jpaRepository.save(mapper.toEntity(rutaPedido)));
    }

    @Override
    public Optional<RutaPedido> buscarPorId(long id) {
        return jpaRepository.findById(Math.toIntExact(id))
                .map(mapper::toDomain);
    }

    @Override
    public List<RutaPedido> buscarPorPedido(long idPedido) {
        return jpaRepository.findByPedido_IdPedido(Math.toIntExact(idPedido))
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public List<RutaPedido> buscarPorRuta(long idRuta) {
        return jpaRepository
                .findByRuta_IdRutaOrderByOrdenEntregaAsc(
                    Math.toIntExact(idRuta))
                .stream().map(mapper::toDomain).toList();
    }

    @Override
    public List<RutaPedido> listarTodos() {
        return jpaRepository.findAll().stream()
                .map(mapper::toDomain).toList();
    }
    
    @Override
    public Optional<RutaPedido> buscarPorRutaYPedido(long idRuta, long idPedido) {
        return jpaRepository.findByRuta_IdRutaAndPedido_IdPedido(
                        Math.toIntExact(idRuta),
                        Math.toIntExact(idPedido)
                )
                .map(mapper::toDomain);
    }


}