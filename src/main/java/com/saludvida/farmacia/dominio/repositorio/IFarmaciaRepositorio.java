package com.saludvida.farmacia.dominio.repositorio;

import java.util.List;
import java.util.Optional;
import com.saludvida.farmacia.dominio.entidades.Farmacia;


public interface IFarmaciaRepositorio {

	  Farmacia guardar(Farmacia farmacia);

	    Optional<Farmacia> buscarPorId(long id);

	    List<Farmacia> buscarPorCiudad(String ciudad);

	    List<Farmacia> buscarPorZona(String zona);

	    List<Farmacia> listarTodos();

	    void cambiarEstadoActivo(long id, boolean activo);
	    
	    List<Farmacia> listarActivos();
}
