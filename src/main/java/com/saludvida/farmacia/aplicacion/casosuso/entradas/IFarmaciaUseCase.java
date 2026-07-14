package com.saludvida.farmacia.aplicacion.casosuso.entradas;

import java.util.List;
import java.util.Optional;

import com.saludvida.farmacia.dominio.entidades.Farmacia;

public interface IFarmaciaUseCase {
	
	 Farmacia crear(Farmacia farmacia);

	    Farmacia actualizar(Farmacia farmacia);

	    Optional<Farmacia> buscarPorId(long id);

	    List<Farmacia> buscarPorCiudad(String ciudad);

	    List<Farmacia> buscarPorZona(String zona);

	    List<Farmacia> listarTodos();

	    List<Farmacia> listarActivos();

	    void activar(long id);

	    void desactivar(long id);

}
