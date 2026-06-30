package com.saludvida.farmacia.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.saludvida.farmacia.dominio.entidades.Proveedor;
import com.saludvida.farmacia.dominio.repositorio.IProveedorRepositorio;
import com.saludvida.farmacia.infraestructura.persistencia.mapeadores.IProveedorJpaMapper;
import com.saludvida.farmacia.infraestructura.repositorios.IProveedorJpaRepository;

@Repository
public final class ProveedorRepositorioImpl
        implements IProveedorRepositorio {

    private final IProveedorJpaRepository jpaRepository;
    private final IProveedorJpaMapper mapper;

    public ProveedorRepositorioImpl(
            IProveedorJpaRepository jpaRepository,
            IProveedorJpaMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Proveedor guardar(Proveedor proveedor) {
        return mapper.toDomain(
                jpaRepository.save(mapper.toEntity(proveedor)));
    }

    @Override
    public Optional<Proveedor> buscarPorId(long id) {
        return jpaRepository.findById(Math.toIntExact(id))
                .map(mapper::toDomain);
    }

    @Override
    public List<Proveedor> listarTodos() {
        return jpaRepository.findAll().stream()
                .map(mapper::toDomain).toList();
    }

    @Override
    public List<Proveedor> listarActivos() {
        return jpaRepository.findAllByActivoTrue().stream()
                .map(mapper::toDomain).toList();
    }

    @Override
    public void cambiarEstadoActivo(long id, boolean activo) {
        var entity = jpaRepository.findById(Math.toIntExact(id))
                .orElseThrow(() ->
                    new IllegalArgumentException("Proveedor no encontrado"));

        entity.setActivo(activo);
        jpaRepository.save(entity);
    }
}
