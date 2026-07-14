package com.saludvida.farmacia.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;



import com.saludvida.farmacia.dominio.entidades.EstadoPedido;
import com.saludvida.farmacia.dominio.entidades.Pedido;
import com.saludvida.farmacia.dominio.repositorio.IPedidoRepositorio;
import com.saludvida.farmacia.infraestructura.persistencia.jpa.PedidoJpa;
import com.saludvida.farmacia.infraestructura.persistencia.mapeadores.IPedidoJpaMapper;
import com.saludvida.farmacia.infraestructura.repositorios.IPedidoJpaRepository;


public final class PedidoRepositorioImpl
        implements IPedidoRepositorio {

    private final IPedidoJpaRepository jpaRepository;
    private final IPedidoJpaMapper mapper;

    public PedidoRepositorioImpl(
            IPedidoJpaRepository jpaRepository,
            IPedidoJpaMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Pedido guardar(Pedido pedido) {
        PedidoJpa entity = mapper.toEntity(pedido);

        if (entity.getIdPedido() != null && entity.getIdPedido() == 0) {
            entity.setIdPedido(null);
        }

        return mapper.toDomain(jpaRepository.save(entity));
    }

    @Override
    public Optional<Pedido> buscarPorId(long id) {
        return jpaRepository.findById(Math.toIntExact(id))
                .map(mapper::toDomain);
    }

    @Override
    public Optional<Pedido> buscarPorNumeroPedido(String numeroPedido) {
        return jpaRepository.findByNumeroPedido(numeroPedido)
                .map(mapper::toDomain);
    }

    @Override
    public List<Pedido> buscarPorCliente(long idCliente) {
        return jpaRepository
                .findByCliente_IdCliente(Math.toIntExact(idCliente))
                .stream().map(mapper::toDomain).toList();
    }

    @Override
    public List<Pedido> buscarPorFarmacia(long idFarmacia) {
        return jpaRepository
                .findByFarmacia_IdFarmacia(Math.toIntExact(idFarmacia))
                .stream().map(mapper::toDomain).toList();
    }

    @Override
    public List<Pedido> buscarPorEstado(EstadoPedido estado) {
        return jpaRepository.findByEstado(estado).stream()
                .map(mapper::toDomain).toList();
    }

    @Override
    public List<Pedido> listarTodos() {
        return jpaRepository.findAll().stream()
                .map(mapper::toDomain).toList();
    }

    @Override
    public void cambiarEstado(long id, EstadoPedido estado) {
        var entity = jpaRepository.findById(Math.toIntExact(id))
                .orElseThrow(() ->
                    new IllegalArgumentException("Pedido no encontrado"));

        entity.setEstado(estado);
        jpaRepository.save(entity);
    }
    
    @Override
    public List<Pedido> buscarPorVendedor(long idVendedor) {
        return jpaRepository.findByVendedor_IdUsuario(Math.toIntExact(idVendedor))
                .stream()
                .map(mapper::toDomain)
                .toList();
    }
}