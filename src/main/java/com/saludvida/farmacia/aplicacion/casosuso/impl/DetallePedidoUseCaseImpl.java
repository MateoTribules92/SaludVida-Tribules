package com.saludvida.farmacia.aplicacion.casosuso.impl;

import java.util.List;
import java.util.Optional;

import com.saludvida.farmacia.aplicacion.casosuso.entradas.IDetallePedidoUseCase;
import com.saludvida.farmacia.dominio.entidades.DetallePedido;
import com.saludvida.farmacia.dominio.repositorio.IDetallePedidoRepositorio;

public final class DetallePedidoUseCaseImpl implements IDetallePedidoUseCase {

    private final IDetallePedidoRepositorio detallePedidoRepositorio;

    public DetallePedidoUseCaseImpl(IDetallePedidoRepositorio detallePedidoRepositorio) {
        this.detallePedidoRepositorio = detallePedidoRepositorio;
    }

    @Override
    public DetallePedido guardar(DetallePedido detallePedido) {
        return detallePedidoRepositorio.guardar(detallePedido);
    }

    @Override
    public Optional<DetallePedido> buscarPorId(long id) {
        return detallePedidoRepositorio.buscarPorId(id);
    }

    @Override
    public List<DetallePedido> buscarPorPedido(long idPedido) {
        return detallePedidoRepositorio.buscarPorPedido(idPedido);
    }

    @Override
    public List<DetallePedido> buscarPorProducto(long idProducto) {
        return detallePedidoRepositorio.buscarPorProducto(idProducto);
    }

    @Override
    public List<DetallePedido> listarTodos() {
        return detallePedidoRepositorio.listarTodos();
    }
}