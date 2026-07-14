package com.saludvida.farmacia.aplicacion.casosuso.impl;

import java.util.List;
import java.util.Optional;

import com.saludvida.farmacia.aplicacion.casosuso.entradas.IVehiculoUseCase;
import com.saludvida.farmacia.dominio.entidades.EstadoVehiculo;
import com.saludvida.farmacia.dominio.entidades.Vehiculo;
import com.saludvida.farmacia.dominio.repositorio.IVehiculoRepositorio;

public final class VehiculoUseCaseImpl implements IVehiculoUseCase {

    private final IVehiculoRepositorio vehiculoRepositorio;

    public VehiculoUseCaseImpl(IVehiculoRepositorio vehiculoRepositorio) {
        this.vehiculoRepositorio = vehiculoRepositorio;
    }

    @Override
    public Vehiculo crear(Vehiculo vehiculo) {
        return vehiculoRepositorio.guardar(vehiculo);
    }

    @Override
    public Vehiculo actualizar(Vehiculo vehiculo) {
        return vehiculoRepositorio.guardar(vehiculo);
    }

    @Override
    public Optional<Vehiculo> buscarPorId(long id) {
        return vehiculoRepositorio.buscarPorId(id);
    }

    @Override
    public Optional<Vehiculo> buscarPorPlaca(String placa) {
        return vehiculoRepositorio.buscarPorPlaca(placa);
    }

    @Override
    public List<Vehiculo> buscarPorEstado(EstadoVehiculo estado) {
        return vehiculoRepositorio.buscarPorEstado(estado);
    }

    @Override
    public List<Vehiculo> listarTodos() {
        return vehiculoRepositorio.listarTodos();
    }

    @Override
    public List<Vehiculo> listarActivos() {
        return vehiculoRepositorio.listarActivos();
    }

    @Override
    public void activar(long id) {
        vehiculoRepositorio.cambiarEstadoActivo(id, true);
    }

    @Override
    public void desactivar(long id) {
        vehiculoRepositorio.cambiarEstadoActivo(id, false);
    }
}