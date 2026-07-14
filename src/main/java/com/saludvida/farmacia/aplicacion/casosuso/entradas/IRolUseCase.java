package com.saludvida.farmacia.aplicacion.casosuso.entradas;

import java.util.List;
import java.util.Optional;

import com.saludvida.farmacia.dominio.entidades.Rol;

public interface IRolUseCase {
	
	 Rol crear(Rol rol);

	    Rol actualizar(Rol rol);

	    Optional<Rol> buscarPorId(long id);

	    Optional<Rol> buscarPorCodigo(String codigo);

	    List<Rol> listarTodos();

	    List<Rol> listarActivos();

	    void activar(long id);

	    void desactivar(long id);

}
