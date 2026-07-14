package com.saludvida.farmacia.aplicacion.casosuso.entradas;

import java.util.List;
import java.util.Optional;

import com.saludvida.farmacia.dominio.entidades.DetallePedido;


public interface IDetallePedidoUseCase {
	
	 DetallePedido guardar(DetallePedido detallePedido);

	    Optional<DetallePedido> buscarPorId(long id);

	    List<DetallePedido> buscarPorPedido(long idPedido);

	    List<DetallePedido> buscarPorProducto(long idProducto);

	    List<DetallePedido> listarTodos();

}
