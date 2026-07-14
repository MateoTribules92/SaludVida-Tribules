package com.saludvida.farmacia.aplicacion.casosuso.entradas;

import java.util.List;
import java.util.Optional;

import com.saludvida.farmacia.dominio.entidades.EstadoVehiculo;
import com.saludvida.farmacia.dominio.entidades.Vehiculo;

public interface IVehiculoUseCase {
	
	   Vehiculo crear(Vehiculo vehiculo);

	    Vehiculo actualizar(Vehiculo vehiculo);

	    Optional<Vehiculo> buscarPorId(long id);

	    Optional<Vehiculo> buscarPorPlaca(String placa);

	    List<Vehiculo> buscarPorEstado(EstadoVehiculo estado);

	    List<Vehiculo> listarTodos();

	    List<Vehiculo> listarActivos();

	    void activar(long id);

	    void desactivar(long id);

}
