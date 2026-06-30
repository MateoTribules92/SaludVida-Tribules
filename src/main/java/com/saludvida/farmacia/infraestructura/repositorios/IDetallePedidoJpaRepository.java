package com.saludvida.farmacia.infraestructura.repositorios;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saludvida.farmacia.infraestructura.persistencia.jpa.DetallePedidoJpa;

public interface IDetallePedidoJpaRepository
        extends JpaRepository<DetallePedidoJpa, Integer> {

    List<DetallePedidoJpa> findByPedido_IdPedido(Integer idPedido);

    Optional<DetallePedidoJpa>
        findByPedido_IdPedidoAndProducto_IdProducto(
            Integer idPedido,
            Integer idProducto);

    boolean existsByPedido_IdPedidoAndProducto_IdProducto(
            Integer idPedido,
            Integer idProducto);
}