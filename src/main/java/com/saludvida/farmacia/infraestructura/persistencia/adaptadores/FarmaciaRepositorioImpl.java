package com.saludvida.farmacia.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.saludvida.farmacia.dominio.entidades.Farmacia;
import com.saludvida.farmacia.dominio.repositorio.IFarmaciaRepositorio;
import com.saludvida.farmacia.infraestructura.persistencia.mapeadores.IFarmaciaJpaMapper;
import com.saludvida.farmacia.infraestructura.repositorios.IFarmaciaJpaRepository;

@Repository
public final class FarmaciaRepositorioImpl
        implements IFarmaciaRepositorio {

    private final IFarmaciaJpaRepository jpaRepository;
    private final IFarmaciaJpaMapper mapper;

    public FarmaciaRepositorioImpl(
            IFarmaciaJpaRepository jpaRepository,
            IFarmaciaJpaMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Farmacia guardar(Farmacia farmacia) {
        return mapper.toDomain(
                jpaRepository.save(mapper.toEntity(farmacia)));
    }

    @Override
    public Optional<Farmacia> buscarPorId(long id) {
        return jpaRepository.findById(Math.toIntExact(id))
                .map(mapper::toDomain);
    }

    @Override
    public List<Farmacia> buscarPorCiudad(String ciudad) {
        return jpaRepository.findByCiudadIgnoreCase(ciudad).stream()
                .map(mapper::toDomain).toList();
    }

    @Override
    public List<Farmacia> buscarPorZona(String zona) {
        return jpaRepository.findByZonaIgnoreCase(zona).stream()
                .map(mapper::toDomain).toList();
    }

    @Override
    public List<Farmacia> listarTodos() {
        return jpaRepository.findAll().stream()
                .map(mapper::toDomain).toList();
    }

    @Override
    public List<Farmacia> listarActivos() {
        return jpaRepository.findAllByActivoTrue().stream()
                .map(mapper::toDomain).toList();
    }

    @Override
    public void cambiarEstadoActivo(long id, boolean activo) {
        var entity = jpaRepository.findById(Math.toIntExact(id))
                .orElseThrow(() ->
                    new IllegalArgumentException("Farmacia no encontrada"));

        entity.setActivo(activo);
        jpaRepository.save(entity);
    }
}