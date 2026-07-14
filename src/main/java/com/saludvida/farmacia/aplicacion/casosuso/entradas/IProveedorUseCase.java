package com.saludvida.farmacia.aplicacion.casosuso.entradas;

import java.util.List;
import java.util.Optional;

import com.saludvida.farmacia.dominio.entidades.Proveedor;

public interface IProveedorUseCase {
	
	 Proveedor crear(Proveedor proveedor);

	    Proveedor actualizar(Proveedor proveedor);

	    Optional<Proveedor> buscarPorId(long id);

	    Optional<Proveedor> buscarPorRuc(String ruc);

	    List<Proveedor> listarTodos();

	    List<Proveedor> listarActivos();

	    void activar(long id);

	    void desactivar(long id);

}
