package com.saludvida.farmacia.dominio.repositorio;

import java.util.List;
import java.util.Optional;
import com.saludvida.farmacia.dominio.entidades.Cliente;

public interface IClienteRepositorio {
	
	  Cliente guardar(Cliente cliente);

	    Optional<Cliente> buscarPorId(long id);

	    Optional<Cliente> buscarPorIdentificacion(String identificacion);

	    List<Cliente> listarTodos();

	    void cambiarEstadoActivo(long id, boolean activo);

}
