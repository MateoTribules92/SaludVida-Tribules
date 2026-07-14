package com.saludvida.farmacia.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;



import com.saludvida.farmacia.dominio.entidades.ClasificacionCliente;
import com.saludvida.farmacia.dominio.entidades.Cliente;
import com.saludvida.farmacia.dominio.repositorio.IClienteRepositorio;
import com.saludvida.farmacia.infraestructura.persistencia.jpa.ClienteJpa;
import com.saludvida.farmacia.infraestructura.persistencia.mapeadores.IClienteJpaMapper;
import com.saludvida.farmacia.infraestructura.repositorios.IClienteJpaRepository;


public final class ClienteRepositorioImpl
        implements IClienteRepositorio {

    private final IClienteJpaRepository jpaRepository;
    private final IClienteJpaMapper mapper;

    public ClienteRepositorioImpl(
            IClienteJpaRepository jpaRepository,
            IClienteJpaMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Cliente guardar(Cliente cliente) {
        ClienteJpa entity = mapper.toEntity(cliente);

        if (entity.getIdCliente() != null && entity.getIdCliente() == 0) {
            entity.setIdCliente(null);
        }

        return mapper.toDomain(jpaRepository.save(entity));
    }

    @Override
    public Optional<Cliente> buscarPorId(long id) {
        return jpaRepository.findById(Math.toIntExact(id))
                .map(mapper::toDomain);
    }

    @Override
    public Optional<Cliente> buscarPorIdentificacion(
            String identificacion) {
        return jpaRepository.findByIdentificacion(identificacion)
                .map(mapper::toDomain);
    }

    @Override
    public List<Cliente> buscarPorClasificacion(
            ClasificacionCliente clasificacion) {
        return jpaRepository.findByClasificacion(clasificacion).stream()
                .map(mapper::toDomain).toList();
    }

    @Override
    public List<Cliente> listarTodos() {
        return jpaRepository.findAll().stream()
                .map(mapper::toDomain).toList();
    }

    @Override
    public List<Cliente> listarActivos() {
        return jpaRepository.findAllByActivoTrue().stream()
                .map(mapper::toDomain).toList();
    }

    @Override
    public void cambiarEstadoActivo(long id, boolean activo) {
        var entity = jpaRepository.findById(Math.toIntExact(id))
                .orElseThrow(() ->
                    new IllegalArgumentException("Cliente no encontrado"));

        entity.setActivo(activo);
        jpaRepository.save(entity);
    }
}