package com.saludvida.farmacia.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;



import com.saludvida.farmacia.dominio.entidades.Inventario;
import com.saludvida.farmacia.dominio.repositorio.IInventarioRepositorio;
import com.saludvida.farmacia.infraestructura.persistencia.jpa.InventarioJpa;
import com.saludvida.farmacia.infraestructura.persistencia.mapeadores.IInventarioJpaMapper;
import com.saludvida.farmacia.infraestructura.repositorios.IInventarioJpaRepository;


public final class InventarioRepositorioImpl
        implements IInventarioRepositorio {

    private final IInventarioJpaRepository jpaRepository;
    private final IInventarioJpaMapper mapper;

    public InventarioRepositorioImpl(
            IInventarioJpaRepository jpaRepository,
            IInventarioJpaMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Inventario guardar(Inventario inventario) {
        InventarioJpa entity = mapper.toEntity(inventario);

        if (entity.getIdInventario() != null && entity.getIdInventario() == 0) {
            entity.setIdInventario(null);
        }

        return mapper.toDomain(jpaRepository.save(entity));
    }

    @Override
    public Optional<Inventario> buscarPorId(long id) {
        return jpaRepository.findById(Math.toIntExact(id))
                .map(mapper::toDomain);
    }

    @Override
    public Optional<Inventario> buscarPorFarmaciaYProducto(
            long idFarmacia,
            long idProducto) {
        return jpaRepository
                .findByFarmacia_IdFarmaciaAndProducto_IdProducto(
                    Math.toIntExact(idFarmacia),
                    Math.toIntExact(idProducto))
                .map(mapper::toDomain);
    }

    @Override
    public List<Inventario> buscarPorFarmacia(long idFarmacia) {
        return jpaRepository
                .findByFarmacia_IdFarmacia(Math.toIntExact(idFarmacia))
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public List<Inventario> buscarConStockBajo() {
        return jpaRepository.buscarInventariosConStockBajo()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public List<Inventario> listarTodos() {
        return jpaRepository.findAll().stream()
                .map(mapper::toDomain).toList();
    }
    
    @Override
    public List<Inventario> buscarPorProducto(long idProducto) {
        return jpaRepository.findByProducto_IdProducto(Math.toIntExact(idProducto))
                .stream()
                .map(mapper::toDomain)
                .toList();
    }
}
