package com.saludvida.farmacia.dominio.repositorio;

import java.util.List;
import java.util.Optional;
import com.saludvida.farmacia.dominio.entidades.DetallePedido;

public interface IDetallePedidoRepositorio {
	
	  DetallePedido guardar(DetallePedido detallePedido);

	    Optional<DetallePedido> buscarPorId(long id);

	    List<DetallePedido> buscarPorPedido(long idPedido);

	    List<DetallePedido> listarTodos();

	   

}
