package com.saludvida.farmacia.aplicacion.casosuso.impl;

import java.util.List;
import java.util.Optional;

import com.saludvida.farmacia.aplicacion.casosuso.entradas.IPedidoUseCase;
import com.saludvida.farmacia.dominio.entidades.EstadoPedido;
import com.saludvida.farmacia.dominio.entidades.Pedido;
import com.saludvida.farmacia.dominio.repositorio.IPedidoRepositorio;

public final class PedidoUseCaseImpl implements IPedidoUseCase {

    private final IPedidoRepositorio pedidoRepositorio;

    public PedidoUseCaseImpl(IPedidoRepositorio pedidoRepositorio) {
        this.pedidoRepositorio = pedidoRepositorio;
    }

    @Override
    public Pedido crear(Pedido pedido) {
        return pedidoRepositorio.guardar(pedido);
    }

    @Override
    public Pedido actualizar(Pedido pedido) {
        return pedidoRepositorio.guardar(pedido);
    }

    @Override
    public Optional<Pedido> buscarPorId(long id) {
        return pedidoRepositorio.buscarPorId(id);
    }

    @Override
    public Optional<Pedido> buscarPorNumeroPedido(String numeroPedido) {
        return pedidoRepositorio.buscarPorNumeroPedido(numeroPedido);
    }

    @Override
    public List<Pedido> buscarPorCliente(long idCliente) {
        return pedidoRepositorio.buscarPorCliente(idCliente);
    }

    @Override
    public List<Pedido> buscarPorFarmacia(long idFarmacia) {
        return pedidoRepositorio.buscarPorFarmacia(idFarmacia);
    }

    @Override
    public List<Pedido> buscarPorVendedor(long idVendedor) {
        return pedidoRepositorio.buscarPorVendedor(idVendedor);
    }

    @Override
    public List<Pedido> buscarPorEstado(EstadoPedido estado) {
        return pedidoRepositorio.buscarPorEstado(estado);
    }

    @Override
    public List<Pedido> listarTodos() {
        return pedidoRepositorio.listarTodos();
    }

    @Override
    public void cambiarEstado(long id, EstadoPedido estado) {
        pedidoRepositorio.cambiarEstado(id, estado);
    }
}