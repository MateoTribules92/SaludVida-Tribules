package com.saludvida.farmacia.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;



import com.saludvida.farmacia.dominio.entidades.Usuario;
import com.saludvida.farmacia.dominio.repositorio.IUsuarioRepositorio;
import com.saludvida.farmacia.infraestructura.persistencia.mapeadores.IUsuarioJpaMapper;
import com.saludvida.farmacia.infraestructura.repositorios.IUsuarioJpaRepository;


public final class UsuarioRepositorioImpl
        implements IUsuarioRepositorio {

    private final IUsuarioJpaRepository jpaRepository;
    private final IUsuarioJpaMapper mapper;

    public UsuarioRepositorioImpl(
            IUsuarioJpaRepository jpaRepository,
            IUsuarioJpaMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Usuario guardar(Usuario usuario) {
        return mapper.toDomain(
                jpaRepository.save(mapper.toEntity(usuario)));
    }

    @Override
    public Optional<Usuario> buscarPorId(long id) {
        return jpaRepository.findById(Math.toIntExact(id))
                .map(mapper::toDomain);
    }

    @Override
    public Optional<Usuario> buscarPorCorreo(String correo) {
        return jpaRepository.findByCorreo(correo)
                .map(mapper::toDomain);
    }

    @Override
    public List<Usuario> listarTodos() {
        return jpaRepository.findAll().stream()
                .map(mapper::toDomain).toList();
    }

    @Override
    public List<Usuario> listarActivos() {
        return jpaRepository.findAllByActivoTrue().stream()
                .map(mapper::toDomain).toList();
    }

    @Override
    public void cambiarEstadoActivo(long id, boolean activo) {
        var entity = jpaRepository.findById(Math.toIntExact(id))
                .orElseThrow(() ->
                    new IllegalArgumentException("Usuario no encontrado"));

        entity.setActivo(activo);
        jpaRepository.save(entity);
    }
}