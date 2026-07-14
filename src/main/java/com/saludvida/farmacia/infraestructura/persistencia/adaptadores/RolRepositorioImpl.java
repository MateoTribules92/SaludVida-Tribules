package com.saludvida.farmacia.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;



import com.saludvida.farmacia.dominio.entidades.Rol;
import com.saludvida.farmacia.dominio.repositorio.IRolRepositorio;
import com.saludvida.farmacia.infraestructura.persistencia.jpa.RolJpa;
import com.saludvida.farmacia.infraestructura.persistencia.mapeadores.IRolJpaMapper;
import com.saludvida.farmacia.infraestructura.repositorios.IRolJpaRepository;


public final class RolRepositorioImpl implements IRolRepositorio {

    private final IRolJpaRepository jpaRepository;
    private final IRolJpaMapper mapper;

    public RolRepositorioImpl(
            IRolJpaRepository jpaRepository,
            IRolJpaMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Rol guardar(Rol rol) {
        RolJpa entity = mapper.toEntity(rol);

        if (entity.getIdRol() != null && entity.getIdRol() == 0) {
            entity.setIdRol(null);
        }

        return mapper.toDomain(jpaRepository.save(entity));
    }

    @Override
    public Optional<Rol> buscarPorId(long id) {
        return jpaRepository.findById(Math.toIntExact(id))
                .map(mapper::toDomain);
    }

    @Override
    public Optional<Rol> buscarPorCodigo(String codigo) {
        return jpaRepository.findByCodigo(codigo)
                .map(mapper::toDomain);
    }

    @Override
    public List<Rol> listarTodos() {
        return jpaRepository.findAll().stream()
                .map(mapper::toDomain).toList();
    }

    @Override
    public List<Rol> listarActivos() {
        return jpaRepository.findAllByActivoTrue().stream()
                .map(mapper::toDomain).toList();
    }

    @Override
    public void cambiarEstadoActivo(long id, boolean activo) {
        var entity = jpaRepository.findById(Math.toIntExact(id))
                .orElseThrow(() ->
                    new IllegalArgumentException("Rol no encontrado"));

        entity.setActivo(activo);
        jpaRepository.save(entity);
    }
}