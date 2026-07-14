package com.saludvida.farmacia.aplicacion.casosuso.impl;

import java.util.List;
import java.util.Optional;

import com.saludvida.farmacia.aplicacion.casosuso.entradas.IInventarioUseCase;
import com.saludvida.farmacia.dominio.entidades.Inventario;
import com.saludvida.farmacia.dominio.repositorio.IInventarioRepositorio;

public final class InventarioUseCaseImpl implements IInventarioUseCase {

    private final IInventarioRepositorio inventarioRepositorio;

    public InventarioUseCaseImpl(IInventarioRepositorio inventarioRepositorio) {
        this.inventarioRepositorio = inventarioRepositorio;
    }

    @Override
    public Inventario guardar(Inventario inventario) {
        return inventarioRepositorio.guardar(inventario);
    }

    @Override
    public Optional<Inventario> buscarPorId(long id) {
        return inventarioRepositorio.buscarPorId(id);
    }

    @Override
    public Optional<Inventario> buscarPorFarmaciaYProducto(long idFarmacia, long idProducto) {
        return inventarioRepositorio.buscarPorFarmaciaYProducto(idFarmacia, idProducto);
    }

    @Override
    public List<Inventario> buscarPorFarmacia(long idFarmacia) {
        return inventarioRepositorio.buscarPorFarmacia(idFarmacia);
    }

    @Override
    public List<Inventario> buscarPorProducto(long idProducto) {
        return inventarioRepositorio.buscarPorProducto(idProducto);
    }

    @Override
    public List<Inventario> buscarConStockBajo() {
        return inventarioRepositorio.buscarConStockBajo();
    }

    @Override
    public List<Inventario> listarTodos() {
        return inventarioRepositorio.listarTodos();
    }
}