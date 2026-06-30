package com.saludvida.farmacia.dominio.repositorio;

import java.util.List;
import java.util.Optional;
import com.saludvida.farmacia.dominio.entidades.MovimientoInventario;

public interface IMovimientoInventarioRepositorio {
	
	  MovimientoInventario guardar(MovimientoInventario movimiento);

	    Optional<MovimientoInventario> buscarPorId(long id);

	    List<MovimientoInventario> buscarPorInventario(long idInventario);

	    List<MovimientoInventario> listarTodos();

	    
}
