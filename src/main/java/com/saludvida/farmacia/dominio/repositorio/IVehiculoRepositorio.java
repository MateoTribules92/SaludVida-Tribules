package com.saludvida.farmacia.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import com.saludvida.farmacia.dominio.entidades.EstadoVehiculo;
import com.saludvida.farmacia.dominio.entidades.Vehiculo;

public interface IVehiculoRepositorio {
	
	 Vehiculo guardar(Vehiculo vehiculo);

	    Optional<Vehiculo> buscarPorId(long id);

	    Optional<Vehiculo> buscarPorPlaca(String placa);

	    List<Vehiculo> buscarPorEstado(EstadoVehiculo estado);

	    List<Vehiculo> listarTodos();

	    void cambiarEstadoActivo(long id, boolean activo);
	    
	    List<Vehiculo> listarActivos();

}
