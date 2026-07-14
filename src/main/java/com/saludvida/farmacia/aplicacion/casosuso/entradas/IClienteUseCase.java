package com.saludvida.farmacia.aplicacion.casosuso.entradas;

import java.util.List;
import java.util.Optional;

import com.saludvida.farmacia.dominio.entidades.Cliente;
import com.saludvida.farmacia.dominio.entidades.ClasificacionCliente;

public interface IClienteUseCase {
	
	 Cliente crear(Cliente cliente);

	    Cliente actualizar(Cliente cliente);

	    Optional<Cliente> buscarPorId(long id);

	    Optional<Cliente> buscarPorIdentificacion(String identificacion);

	    List<Cliente> buscarPorClasificacion(ClasificacionCliente clasificacion);

	    List<Cliente> listarTodos();

	    List<Cliente> listarActivos();

	    void activar(long id);

	    void desactivar(long id);

}
