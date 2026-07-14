package com.saludvida.farmacia.infraestructura.persistencia.adaptadores;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;



import com.saludvida.farmacia.dominio.entidades.Producto;
import com.saludvida.farmacia.dominio.repositorio.IProductoRepositorio;
import com.saludvida.farmacia.infraestructura.persistencia.jpa.ProductoJpa;
import com.saludvida.farmacia.infraestructura.persistencia.mapeadores.IProductoJpaMapper;
import com.saludvida.farmacia.infraestructura.repositorios.IProductoJpaRepository;


public final class ProductoRepositorioImpl
        implements IProductoRepositorio {

    private final IProductoJpaRepository jpaRepository;
    private final IProductoJpaMapper mapper;

    public ProductoRepositorioImpl(
            IProductoJpaRepository jpaRepository,
            IProductoJpaMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Producto guardar(Producto producto) {
        ProductoJpa entity = mapper.toEntity(producto);

        if (entity.getIdProducto() != null && entity.getIdProducto() == 0) {
            entity.setIdProducto(null);
        }

        return mapper.toDomain(jpaRepository.save(entity));
    }

    @Override
    public Optional<Producto> buscarPorId(long id) {
        return jpaRepository.findById(Math.toIntExact(id))
                .map(mapper::toDomain);
    }

    @Override
    public Optional<Producto> buscarPorCodigo(String codigo) {
        return jpaRepository.findByCodigo(codigo)
                .map(mapper::toDomain);
    }

    @Override
    public List<Producto> listarTodos() {
        return jpaRepository.findAll().stream()
                .map(mapper::toDomain).toList();
    }

    @Override
    public List<Producto> listarActivos() {
        return jpaRepository.findAllByActivoTrue().stream()
                .map(mapper::toDomain).toList();
    }

    @Override
    public List<Producto> buscarVencidos(LocalDate fecha) {
        return jpaRepository.findByFechaCaducidadBefore(fecha).stream()
                .map(mapper::toDomain).toList();
    }

    @Override
    public List<Producto> buscarProximosACaducar(LocalDate fechaLimite) {
        return jpaRepository
                .findByFechaCaducidadBetween(
                    LocalDate.now(),
                    fechaLimite)
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public void cambiarEstadoActivo(long id, boolean activo) {
        var entity = jpaRepository.findById(Math.toIntExact(id))
                .orElseThrow(() ->
                    new IllegalArgumentException("Producto no encontrado"));

        entity.setActivo(activo);
        jpaRepository.save(entity);
    }

    @Override
    public List<Producto> buscarPorCategoria(long idCategoria) {
        return jpaRepository.findByCategoria_IdCategoria(Math.toIntExact(idCategoria))
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public List<Producto> buscarPorProveedor(long idProveedor) {
        return jpaRepository.findByProveedor_IdProveedor(Math.toIntExact(idProveedor))
                .stream()
                .map(mapper::toDomain)
                .toList();
    }
}