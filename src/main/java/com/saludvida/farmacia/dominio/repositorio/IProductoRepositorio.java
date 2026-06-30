package com.saludvida.farmacia.dominio.repositorio;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import com.saludvida.farmacia.dominio.entidades.Producto;


public interface IProductoRepositorio {
	
	 Producto guardar(Producto producto);

	    Optional<Producto> buscarPorId(long id);

	    Optional<Producto> buscarPorCodigo(String codigo);

	    List<Producto> listarTodos();

	    void cambiarEstadoActivo(long id, boolean activo);
	    
	    List<Producto> listarActivos();
	    
	    List<Producto> buscarVencidos(LocalDate fecha);

	    List<Producto> buscarProximosACaducar(LocalDate fechaLimite);

}
