package com.saludvida.farmacia.dominio.repositorio;

import java.util.List;
import java.util.Optional;
import com.saludvida.farmacia.dominio.entidades.HistorialEstadoPedido;

public interface IHistorialEstadoPedidoRepositorio {
	
	  HistorialEstadoPedido guardar(HistorialEstadoPedido historial);

	    Optional<HistorialEstadoPedido> buscarPorId(long id);

	    List<HistorialEstadoPedido> buscarPorPedido(long idPedido);

	    List<HistorialEstadoPedido> listarTodos();

	    

}
