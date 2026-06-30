package com.saludvida.farmacia.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import com.saludvida.farmacia.dominio.entidades.ClasificacionCliente;
import com.saludvida.farmacia.dominio.entidades.Cliente;

public interface IClienteRepositorio {
	
	 Cliente guardar(Cliente cliente);

	    Optional<Cliente> buscarPorId(long id);

	    Optional<Cliente> buscarPorIdentificacion(String identificacion);

	    List<Cliente> buscarPorClasificacion(
	            ClasificacionCliente clasificacion);

	    List<Cliente> listarTodos();

	    List<Cliente> listarActivos();

	    void cambiarEstadoActivo(long id, boolean activo);

}
