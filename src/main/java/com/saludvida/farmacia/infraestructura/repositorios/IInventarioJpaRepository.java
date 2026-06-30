package com.saludvida.farmacia.infraestructura.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.saludvida.farmacia.infraestructura.persistencia.jpa.InventarioJpa;

public interface IInventarioJpaRepository
        extends JpaRepository<InventarioJpa, Integer> {

    Optional<InventarioJpa>
        findByFarmacia_IdFarmaciaAndProducto_IdProducto(
            Integer idFarmacia,
            Integer idProducto);

    List<InventarioJpa> findByFarmacia_IdFarmacia(Integer idFarmacia);

    List<InventarioJpa> findByProducto_IdProducto(Integer idProducto);

    @Query("""
        SELECT i
        FROM InventarioJpa i
        WHERE i.stock <= i.stockMinimo
        """)
    List<InventarioJpa> buscarInventariosConStockBajo();
}