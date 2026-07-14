package com.saludvida.farmacia.infraestructura.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saludvida.farmacia.infraestructura.persistencia.jpa.HistorialEstadoPedidoJpa;

public interface IHistorialEstadoPedidoJpaRepository
        extends JpaRepository<HistorialEstadoPedidoJpa, Integer> {

    List<HistorialEstadoPedidoJpa>
        findByPedido_IdPedidoOrderByFechaRegistroAsc(
            Integer idPedido);

    List<HistorialEstadoPedidoJpa>
        findByUsuario_IdUsuarioOrderByFechaRegistroDesc(
            Integer idUsuario);
    
    List<HistorialEstadoPedidoJpa> findByUsuario_IdUsuario(Integer idUsuario);
}
