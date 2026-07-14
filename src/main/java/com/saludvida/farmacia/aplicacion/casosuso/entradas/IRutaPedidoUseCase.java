package com.saludvida.farmacia.aplicacion.casosuso.entradas;

import java.util.List;
import java.util.Optional;

import com.saludvida.farmacia.dominio.entidades.RutaPedido;

public interface IRutaPedidoUseCase {
	
	 RutaPedido asignar(RutaPedido rutaPedido);

	    RutaPedido actualizar(RutaPedido rutaPedido);

	    Optional<RutaPedido> buscarPorId(long id);

	    Optional<RutaPedido> buscarPorRutaYPedido(long idRuta, long idPedido);

	    List<RutaPedido> buscarPorRuta(long idRuta);

	    List<RutaPedido> buscarPorPedido(long idPedido);

	    List<RutaPedido> listarTodos();

}
