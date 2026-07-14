package com.saludvida.farmacia.aplicacion.casosuso.entradas;

import java.util.List;
import java.util.Optional;

import com.saludvida.farmacia.dominio.entidades.EstadoPedido;
import com.saludvida.farmacia.dominio.entidades.Pedido;

public interface IPedidoUseCase {
	
	 Pedido crear(Pedido pedido);

	    Pedido actualizar(Pedido pedido);

	    Optional<Pedido> buscarPorId(long id);

	    Optional<Pedido> buscarPorNumeroPedido(String numeroPedido);

	    List<Pedido> buscarPorCliente(long idCliente);

	    List<Pedido> buscarPorFarmacia(long idFarmacia);

	    List<Pedido> buscarPorVendedor(long idVendedor);

	    List<Pedido> buscarPorEstado(EstadoPedido estado);

	    List<Pedido> listarTodos();

	    void cambiarEstado(long id, EstadoPedido estado);

}
