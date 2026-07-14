package com.saludvida.farmacia.aplicacion.casosuso.impl;

import java.util.List;
import java.util.Optional;

import com.saludvida.farmacia.aplicacion.casosuso.entradas.IFarmaciaUseCase;
import com.saludvida.farmacia.dominio.entidades.Farmacia;
import com.saludvida.farmacia.dominio.repositorio.IFarmaciaRepositorio;

public final class FarmaciaUseCaseImpl implements IFarmaciaUseCase {

    private final IFarmaciaRepositorio farmaciaRepositorio;

    public FarmaciaUseCaseImpl(IFarmaciaRepositorio farmaciaRepositorio) {
        this.farmaciaRepositorio = farmaciaRepositorio;
    }

    @Override
    public Farmacia crear(Farmacia farmacia) {
        return farmaciaRepositorio.guardar(farmacia);
    }

    @Override
    public Farmacia actualizar(Farmacia farmacia) {
        return farmaciaRepositorio.guardar(farmacia);
    }

    @Override
    public Optional<Farmacia> buscarPorId(long id) {
        return farmaciaRepositorio.buscarPorId(id);
    }

    @Override
    public List<Farmacia> buscarPorCiudad(String ciudad) {
        return farmaciaRepositorio.buscarPorCiudad(ciudad);
    }

    @Override
    public List<Farmacia> buscarPorZona(String zona) {
        return farmaciaRepositorio.buscarPorZona(zona);
    }

    @Override
    public List<Farmacia> listarTodos() {
        return farmaciaRepositorio.listarTodos();
    }

    @Override
    public List<Farmacia> listarActivos() {
        return farmaciaRepositorio.listarActivos();
    }

    @Override
    public void activar(long id) {
        farmaciaRepositorio.cambiarEstadoActivo(id, true);
    }

    @Override
    public void desactivar(long id) {
        farmaciaRepositorio.cambiarEstadoActivo(id, false);
    }
}