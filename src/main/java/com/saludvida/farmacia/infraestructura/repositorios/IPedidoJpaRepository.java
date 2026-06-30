package com.saludvida.farmacia.infraestructura.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saludvida.farmacia.dominio.entidades.EstadoPedido;
import com.saludvida.farmacia.infraestructura.persistencia.jpa.PedidoJpa;

public interface IPedidoJpaRepository
        extends JpaRepository<PedidoJpa, Integer> {

    Optional<PedidoJpa> findByNumeroPedido(String numeroPedido);

    boolean existsByNumeroPedido(String numeroPedido);

    List<PedidoJpa> findByCliente_IdCliente(Integer idCliente);

    List<PedidoJpa> findByFarmacia_IdFarmacia(Integer idFarmacia);

    List<PedidoJpa> findByVendedor_IdUsuario(Integer idVendedor);

    List<PedidoJpa> findByEstado(EstadoPedido estado);
}
