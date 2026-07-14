package com.saludvida.farmacia.aplicacion.casosuso.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.saludvida.farmacia.aplicacion.casosuso.entradas.IRutaUseCase;
import com.saludvida.farmacia.dominio.entidades.EstadoRuta;
import com.saludvida.farmacia.dominio.entidades.Ruta;
import com.saludvida.farmacia.dominio.repositorio.IRutaRepositorio;

public final class RutaUseCaseImpl implements IRutaUseCase {

    private final IRutaRepositorio rutaRepositorio;

    public RutaUseCaseImpl(IRutaRepositorio rutaRepositorio) {
        this.rutaRepositorio = rutaRepositorio;
    }

    @Override
    public Ruta crear(Ruta ruta) {
        return rutaRepositorio.guardar(ruta);
    }

    @Override
    public Ruta actualizar(Ruta ruta) {
        return rutaRepositorio.guardar(ruta);
    }

    @Override
    public Optional<Ruta> buscarPorId(long id) {
        return rutaRepositorio.buscarPorId(id);
    }

    @Override
    public Optional<Ruta> buscarPorCodigoRuta(String codigoRuta) {
        return rutaRepositorio.buscarPorCodigoRuta(codigoRuta);
    }

    @Override
    public List<Ruta> buscarPorFecha(LocalDate fecha) {
        return rutaRepositorio.buscarPorFecha(fecha);
    }

    @Override
    public List<Ruta> buscarPorEstado(EstadoRuta estado) {
        return rutaRepositorio.buscarPorEstado(estado);
    }

    @Override
    public List<Ruta> buscarPorZona(String zona) {
        return rutaRepositorio.buscarPorZona(zona);
    }

    @Override
    public List<Ruta> listarTodos() {
        return rutaRepositorio.listarTodos();
    }

    @Override
    public boolean existeRutaActivaPorVehiculoYFecha(long idVehiculo, LocalDate fecha) {
        return rutaRepositorio.existeRutaActivaPorVehiculoYFecha(idVehiculo, fecha);
    }

    @Override
    public boolean existeRutaActivaPorDistribuidorYFecha(long idDistribuidor, LocalDate fecha) {
        return rutaRepositorio.existeRutaActivaPorDistribuidorYFecha(idDistribuidor, fecha);
    }

    @Override
    public void cambiarEstado(long id, EstadoRuta estado) {
        rutaRepositorio.cambiarEstado(id, estado);
    }
}
