package com.saludvida.farmacia.aplicacion.casosuso.impl;

import java.util.List;
import java.util.Optional;

import com.saludvida.farmacia.aplicacion.casosuso.entradas.IRutaPedidoUseCase;
import com.saludvida.farmacia.dominio.entidades.RutaPedido;
import com.saludvida.farmacia.dominio.repositorio.IRutaPedidoRepositorio;

public final class RutaPedidoUseCaseImpl implements IRutaPedidoUseCase {

    private final IRutaPedidoRepositorio rutaPedidoRepositorio;

    public RutaPedidoUseCaseImpl(IRutaPedidoRepositorio rutaPedidoRepositorio) {
        this.rutaPedidoRepositorio = rutaPedidoRepositorio;
    }

    @Override
    public RutaPedido asignar(RutaPedido rutaPedido) {
        return rutaPedidoRepositorio.guardar(rutaPedido);
    }

    @Override
    public RutaPedido actualizar(RutaPedido rutaPedido) {
        return rutaPedidoRepositorio.guardar(rutaPedido);
    }

    @Override
    public Optional<RutaPedido> buscarPorId(long id) {
        return rutaPedidoRepositorio.buscarPorId(id);
    }

    @Override
    public Optional<RutaPedido> buscarPorRutaYPedido(long idRuta, long idPedido) {
        return rutaPedidoRepositorio.buscarPorRutaYPedido(idRuta, idPedido);
    }

    @Override
    public List<RutaPedido> buscarPorRuta(long idRuta) {
        return rutaPedidoRepositorio.buscarPorRuta(idRuta);
    }

    @Override
    public List<RutaPedido> buscarPorPedido(long idPedido) {
        return rutaPedidoRepositorio.buscarPorPedido(idPedido);
    }

    @Override
    public List<RutaPedido> listarTodos() {
        return rutaPedidoRepositorio.listarTodos();
    }
}
