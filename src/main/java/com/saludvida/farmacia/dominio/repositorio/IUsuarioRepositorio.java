package com.saludvida.farmacia.dominio.repositorio;

import java.util.List;
import java.util.Optional;


import com.saludvida.farmacia.dominio.entidades.Usuario;

public interface IUsuarioRepositorio {
	
	 Usuario guardar(Usuario usuario);

	    Optional<Usuario> buscarPorId(long id);

	    Optional<Usuario> buscarPorCorreo(String correo);

	    List<Usuario> listarTodos();

	    void cambiarEstadoActivo(long id, boolean activo);
	    
	    List<Usuario> listarActivos();

}
