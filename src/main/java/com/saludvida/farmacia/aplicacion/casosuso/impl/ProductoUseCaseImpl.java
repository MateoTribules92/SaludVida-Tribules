package com.saludvida.farmacia.aplicacion.casosuso.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.saludvida.farmacia.aplicacion.casosuso.entradas.IProductoUseCase;
import com.saludvida.farmacia.dominio.entidades.Producto;
import com.saludvida.farmacia.dominio.repositorio.IProductoRepositorio;

public final class ProductoUseCaseImpl implements IProductoUseCase {

    private final IProductoRepositorio productoRepositorio;

    public ProductoUseCaseImpl(IProductoRepositorio productoRepositorio) {
        this.productoRepositorio = productoRepositorio;
    }

    @Override
    public Producto crear(Producto producto) {
        return productoRepositorio.guardar(producto);
    }

    @Override
    public Producto actualizar(Producto producto) {
        return productoRepositorio.guardar(producto);
    }

    @Override
    public Optional<Producto> buscarPorId(long id) {
        return productoRepositorio.buscarPorId(id);
    }

    @Override
    public Optional<Producto> buscarPorCodigo(String codigo) {
        return productoRepositorio.buscarPorCodigo(codigo);
    }

    @Override
    public List<Producto> buscarPorCategoria(long idCategoria) {
        return productoRepositorio.buscarPorCategoria(idCategoria);
    }

    @Override
    public List<Producto> buscarPorProveedor(long idProveedor) {
        return productoRepositorio.buscarPorProveedor(idProveedor);
    }

    @Override
    public List<Producto> buscarVencidos(LocalDate fecha) {
        return productoRepositorio.buscarVencidos(fecha);
    }

    @Override
    public List<Producto> buscarProximosACaducar(LocalDate fechaLimite) {
        return productoRepositorio.buscarProximosACaducar(fechaLimite);
    }

    @Override
    public List<Producto> listarTodos() {
        return productoRepositorio.listarTodos();
    }

    @Override
    public List<Producto> listarActivos() {
        return productoRepositorio.listarActivos();
    }

    @Override
    public void activar(long id) {
        productoRepositorio.cambiarEstadoActivo(id, true);
    }

    @Override
    public void desactivar(long id) {
        productoRepositorio.cambiarEstadoActivo(id, false);
    }
}
