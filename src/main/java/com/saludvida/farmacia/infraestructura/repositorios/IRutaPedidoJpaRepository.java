package com.saludvida.farmacia.infraestructura.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saludvida.farmacia.infraestructura.persistencia.jpa.RutaPedidoJpa;

public interface IRutaPedidoJpaRepository
        extends JpaRepository<RutaPedidoJpa, Integer> {

    List<RutaPedidoJpa>
        findByRuta_IdRutaOrderByOrdenEntregaAsc(Integer idRuta);

    boolean existsByPedido_IdPedido(Integer idPedido);

    long countByRuta_IdRuta(Integer idRuta);
    
    Optional<RutaPedidoJpa> findByRuta_IdRutaAndPedido_IdPedido(Integer idRuta, Integer idPedido);

    List<RutaPedidoJpa> findByRuta_IdRuta(Integer idRuta);

    List<RutaPedidoJpa> findByPedido_IdPedido(Integer idPedido);
}
