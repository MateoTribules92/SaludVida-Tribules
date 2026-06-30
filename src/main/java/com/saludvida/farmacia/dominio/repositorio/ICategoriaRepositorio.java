package com.saludvida.farmacia.dominio.repositorio;

import java.util.List;
import java.util.Optional;
import com.saludvida.farmacia.dominio.entidades.Categoria;

public interface ICategoriaRepositorio {
	
	Categoria guardar(Categoria categoria);

    Optional<Categoria> buscarPorId(long id);

    List<Categoria> listarTodos();

    void cambiarEstadoActivo(long id, boolean activo);
    
    List<Categoria> listarActivos();

}
