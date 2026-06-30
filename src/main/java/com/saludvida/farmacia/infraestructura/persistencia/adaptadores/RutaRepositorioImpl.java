package com.saludvida.farmacia.infraestructura.persistencia.adaptadores;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.saludvida.farmacia.dominio.entidades.EstadoRuta;
import com.saludvida.farmacia.dominio.entidades.Ruta;
import com.saludvida.farmacia.dominio.repositorio.IRutaRepositorio;
import com.saludvida.farmacia.infraestructura.persistencia.mapeadores.IRutaJpaMapper;
import com.saludvida.farmacia.infraestructura.repositorios.IRutaJpaRepository;

@Repository
public final class RutaRepositorioImpl implements IRutaRepositorio {

    private final IRutaJpaRepository jpaRepository;
    private final IRutaJpaMapper mapper;

    public RutaRepositorioImpl(
            IRutaJpaRepository jpaRepository,
            IRutaJpaMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Ruta guardar(Ruta ruta) {
        return mapper.toDomain(
                jpaRepository.save(mapper.toEntity(ruta)));
    }

    @Override
    public Optional<Ruta> buscarPorId(long id) {
        return jpaRepository.findById(Math.toIntExact(id))
                .map(mapper::toDomain);
    }

    @Override
    public Optional<Ruta> buscarPorCodigo(String codigo) {
        return jpaRepository.findByCodigoRuta(codigo)
                .map(mapper::toDomain);
    }

    @Override
    public List<Ruta> buscarPorFecha(LocalDate fecha) {
        return jpaRepository.findByFechaRuta(fecha).stream()
                .map(mapper::toDomain).toList();
    }

    @Override
    public List<Ruta> buscarPorEstado(EstadoRuta estado) {
        return jpaRepository.findByEstado(estado).stream()
                .map(mapper::toDomain).toList();
    }

    @Override
    public List<Ruta> listarTodos() {
        return jpaRepository.findAll().stream()
                .map(mapper::toDomain).toList();
    }

    @Override
    public boolean existeRutaActivaPorVehiculoYFecha(
            long idVehiculo,
            LocalDate fecha) {
        return jpaRepository
                .existsByVehiculo_IdVehiculoAndFechaRutaAndEstadoNotIn(
                    Math.toIntExact(idVehiculo),
                    fecha,
                    List.of(EstadoRuta.FINALIZADA,
                            EstadoRuta.CANCELADA));
    }

    @Override
    public boolean existeRutaActivaPorDistribuidorYFecha(
            long idDistribuidor,
            LocalDate fecha) {
        return jpaRepository
                .existsByDistribuidor_IdUsuarioAndFechaRutaAndEstadoNotIn(
                    Math.toIntExact(idDistribuidor),
                    fecha,
                    List.of(EstadoRuta.FINALIZADA,
                            EstadoRuta.CANCELADA));
    }

    @Override
    public void cambiarEstado(long id, EstadoRuta estado) {
        var entity = jpaRepository.findById(Math.toIntExact(id))
                .orElseThrow(() ->
                    new IllegalArgumentException("Ruta no encontrada"));

        entity.setEstado(estado);
        jpaRepository.save(entity);
    }
}