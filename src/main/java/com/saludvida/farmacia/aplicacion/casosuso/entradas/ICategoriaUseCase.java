package com.saludvida.farmacia.aplicacion.casosuso.entradas;

import java.util.List;
import java.util.Optional;

import com.saludvida.farmacia.dominio.entidades.Categoria;

public interface ICategoriaUseCase {
	
	 Categoria crear(Categoria categoria);

	    Categoria actualizar(Categoria categoria);

	    Optional<Categoria> buscarPorId(long id);

	    Optional<Categoria> buscarPorNombre(String nombre);

	    List<Categoria> listarTodos();

	    List<Categoria> listarActivos();

	    void activar(long id);

	    void desactivar(long id);

}
