package com.saludvida.farmacia.aplicacion.casosuso.entradas;

import java.util.List;
import java.util.Optional;

import com.saludvida.farmacia.dominio.entidades.HistorialEstadoPedido;

public interface IHistorialEstadoPedidoUseCase {
	
	 HistorialEstadoPedido registrar(HistorialEstadoPedido historialEstadoPedido);

	    Optional<HistorialEstadoPedido> buscarPorId(long id);

	    List<HistorialEstadoPedido> buscarPorPedido(long idPedido);

	    List<HistorialEstadoPedido> buscarPorUsuario(long idUsuario);

	    List<HistorialEstadoPedido> listarTodos();

}
