package com.saludvida.farmacia.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import com.saludvida.farmacia.dominio.entidades.Proveedor;

public interface IProveedorRepositorio {
	
	 Proveedor guardar(Proveedor proveedor);

	    Optional<Proveedor> buscarPorId(long id);

	    List<Proveedor> listarTodos();

	    void cambiarEstadoActivo(long id, boolean activo);
	    
	    List<Proveedor> listarActivos();
}
