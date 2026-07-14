package com.saludvida.farmacia.dominio.repositorio;

import java.util.List;
import java.util.Optional;
import com.saludvida.farmacia.dominio.entidades.RutaPedido;

public interface IRutaPedidoRepositorio {

	 RutaPedido guardar(RutaPedido rutaPedido);

	    Optional<RutaPedido> buscarPorId(long id);

	    List<RutaPedido> buscarPorPedido(long idPedido);

	    List<RutaPedido> buscarPorRuta(long idRuta);

	    List<RutaPedido> listarTodos();
	    
	    Optional<RutaPedido> buscarPorRutaYPedido(long idRuta, long idPedido);



	  
}
