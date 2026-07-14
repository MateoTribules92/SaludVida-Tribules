package com.saludvida.farmacia.aplicacion.casosuso.entradas;
import java.util.List;
import java.util.Optional;

import com.saludvida.farmacia.dominio.entidades.Usuario;

public interface IUsuarioUseCase {
	
	 Usuario crear(Usuario usuario);

	    Usuario actualizar(Usuario usuario);

	    Optional<Usuario> buscarPorId(long id);

	    Optional<Usuario> buscarPorCorreo(String correo);

	    List<Usuario> listarTodos();

	    List<Usuario> listarActivos();

	    void activar(long id);

	    void desactivar(long id);

}
