package com.saludvida.farmacia.dominio.repositorio;

import java.util.List;
import java.util.Optional;
import com.saludvida.farmacia.dominio.entidades.Rol;

public interface IRolRepositorio {
	
	 Rol guardar(Rol rol);

	    Optional<Rol> buscarPorId(long id);

	    List<Rol> listarTodos();

	    void cambiarEstadoActivo(long id, boolean activo);
}
