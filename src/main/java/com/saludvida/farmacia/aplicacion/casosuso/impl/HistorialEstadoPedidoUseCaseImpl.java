package com.saludvida.farmacia.aplicacion.casosuso.impl;

import java.util.List;
import java.util.Optional;

import com.saludvida.farmacia.aplicacion.casosuso.entradas.IHistorialEstadoPedidoUseCase;
import com.saludvida.farmacia.dominio.entidades.HistorialEstadoPedido;
import com.saludvida.farmacia.dominio.repositorio.IHistorialEstadoPedidoRepositorio;

public final class HistorialEstadoPedidoUseCaseImpl implements IHistorialEstadoPedidoUseCase {

    private final IHistorialEstadoPedidoRepositorio historialEstadoPedidoRepositorio;

    public HistorialEstadoPedidoUseCaseImpl(IHistorialEstadoPedidoRepositorio historialEstadoPedidoRepositorio) {
        this.historialEstadoPedidoRepositorio = historialEstadoPedidoRepositorio;
    }

    @Override
    public HistorialEstadoPedido registrar(HistorialEstadoPedido historialEstadoPedido) {
        return historialEstadoPedidoRepositorio.guardar(historialEstadoPedido);
    }

    @Override
    public Optional<HistorialEstadoPedido> buscarPorId(long id) {
        return historialEstadoPedidoRepositorio.buscarPorId(id);
    }

    @Override
    public List<HistorialEstadoPedido> buscarPorPedido(long idPedido) {
        return historialEstadoPedidoRepositorio.buscarPorPedido(idPedido);
    }

    @Override
    public List<HistorialEstadoPedido> buscarPorUsuario(long idUsuario) {
        return historialEstadoPedidoRepositorio.buscarPorUsuario(idUsuario);
    }

    @Override
    public List<HistorialEstadoPedido> listarTodos() {
        return historialEstadoPedidoRepositorio.listarTodos();
    }
}