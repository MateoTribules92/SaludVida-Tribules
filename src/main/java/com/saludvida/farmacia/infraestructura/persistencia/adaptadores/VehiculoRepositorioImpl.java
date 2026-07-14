package com.saludvida.farmacia.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;



import com.saludvida.farmacia.dominio.entidades.EstadoVehiculo;
import com.saludvida.farmacia.dominio.entidades.Vehiculo;
import com.saludvida.farmacia.dominio.repositorio.IVehiculoRepositorio;
import com.saludvida.farmacia.infraestructura.persistencia.mapeadores.IVehiculoJpaMapper;
import com.saludvida.farmacia.infraestructura.repositorios.IVehiculoJpaRepository;


public final class VehiculoRepositorioImpl
        implements IVehiculoRepositorio {

    private final IVehiculoJpaRepository jpaRepository;
    private final IVehiculoJpaMapper mapper;

    public VehiculoRepositorioImpl(
            IVehiculoJpaRepository jpaRepository,
            IVehiculoJpaMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Vehiculo guardar(Vehiculo vehiculo) {
        return mapper.toDomain(
                jpaRepository.save(mapper.toEntity(vehiculo)));
    }

    @Override
    public Optional<Vehiculo> buscarPorId(long id) {
        return jpaRepository.findById(Math.toIntExact(id))
                .map(mapper::toDomain);
    }

    @Override
    public Optional<Vehiculo> buscarPorPlaca(String placa) {
        return jpaRepository.findByPlaca(placa)
                .map(mapper::toDomain);
    }

    @Override
    public List<Vehiculo> buscarPorEstado(EstadoVehiculo estado) {
        return jpaRepository.findByEstadoAndActivoTrue(estado).stream()
                .map(mapper::toDomain).toList();
    }

    @Override
    public List<Vehiculo> listarTodos() {
        return jpaRepository.findAll().stream()
                .map(mapper::toDomain).toList();
    }

    @Override
    public List<Vehiculo> listarActivos() {
        return jpaRepository.findAllByActivoTrue().stream()
                .map(mapper::toDomain).toList();
    }

    @Override
    public void cambiarEstadoActivo(long id, boolean activo) {
        var entity = jpaRepository.findById(Math.toIntExact(id))
                .orElseThrow(() ->
                    new IllegalArgumentException("Vehículo no encontrado"));

        entity.setActivo(activo);
        jpaRepository.save(entity);
    }
}