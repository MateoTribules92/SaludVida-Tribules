package com.saludvida.farmacia.aplicacion.casosuso.impl;

import java.util.List;
import java.util.Optional;

import com.saludvida.farmacia.aplicacion.casosuso.entradas.IProveedorUseCase;
import com.saludvida.farmacia.dominio.entidades.Proveedor;
import com.saludvida.farmacia.dominio.repositorio.IProveedorRepositorio;

public final class ProveedorUseCaseImpl implements IProveedorUseCase {

    private final IProveedorRepositorio proveedorRepositorio;

    public ProveedorUseCaseImpl(IProveedorRepositorio proveedorRepositorio) {
        this.proveedorRepositorio = proveedorRepositorio;
    }

    @Override
    public Proveedor crear(Proveedor proveedor) {
        return proveedorRepositorio.guardar(proveedor);
    }

    @Override
    public Proveedor actualizar(Proveedor proveedor) {
        return proveedorRepositorio.guardar(proveedor);
    }

    @Override
    public Optional<Proveedor> buscarPorId(long id) {
        return proveedorRepositorio.buscarPorId(id);
    }

    @Override
    public Optional<Proveedor> buscarPorRuc(String ruc) {
        return proveedorRepositorio.buscarPorRuc(ruc);
    }

    @Override
    public List<Proveedor> listarTodos() {
        return proveedorRepositorio.listarTodos();
    }

    @Override
    public List<Proveedor> listarActivos() {
        return proveedorRepositorio.listarActivos();
    }

    @Override
    public void activar(long id) {
        proveedorRepositorio.cambiarEstadoActivo(id, true);
    }

    @Override
    public void desactivar(long id) {
        proveedorRepositorio.cambiarEstadoActivo(id, false);
    }
}