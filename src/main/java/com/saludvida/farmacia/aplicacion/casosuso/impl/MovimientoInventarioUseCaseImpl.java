package com.saludvida.farmacia.aplicacion.casosuso.impl;

import java.util.List;
import java.util.Optional;

import com.saludvida.farmacia.aplicacion.casosuso.entradas.IMovimientoInventarioUseCase;
import com.saludvida.farmacia.dominio.entidades.MovimientoInventario;
import com.saludvida.farmacia.dominio.entidades.TipoMovimiento;
import com.saludvida.farmacia.dominio.repositorio.IMovimientoInventarioRepositorio;

public final class MovimientoInventarioUseCaseImpl implements IMovimientoInventarioUseCase {

    private final IMovimientoInventarioRepositorio movimientoInventarioRepositorio;

    public MovimientoInventarioUseCaseImpl(IMovimientoInventarioRepositorio movimientoInventarioRepositorio) {
        this.movimientoInventarioRepositorio = movimientoInventarioRepositorio;
    }

    @Override
    public MovimientoInventario registrar(MovimientoInventario movimientoInventario) {
        return movimientoInventarioRepositorio.guardar(movimientoInventario);
    }

    @Override
    public Optional<MovimientoInventario> buscarPorId(long id) {
        return movimientoInventarioRepositorio.buscarPorId(id);
    }

    @Override
    public List<MovimientoInventario> buscarPorInventario(long idInventario) {
        return movimientoInventarioRepositorio.buscarPorInventario(idInventario);
    }

    @Override
    public List<MovimientoInventario> buscarPorUsuario(long idUsuario) {
        return movimientoInventarioRepositorio.buscarPorUsuario(idUsuario);
    }

    @Override
    public List<MovimientoInventario> buscarPorTipoMovimiento(TipoMovimiento tipoMovimiento) {
        return movimientoInventarioRepositorio.buscarPorTipoMovimiento(tipoMovimiento);
    }

    @Override
    public List<MovimientoInventario> listarTodos() {
        return movimientoInventarioRepositorio.listarTodos();
    }
}