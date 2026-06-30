package com.saludvida.farmacia.dominio.repositorio;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.saludvida.farmacia.dominio.entidades.EstadoRuta;
import com.saludvida.farmacia.dominio.entidades.Ruta;

public interface IRutaRepositorio {
	
	Ruta guardar(Ruta ruta);

    Optional<Ruta> buscarPorId(long id);

    Optional<Ruta> buscarPorCodigo(String codigoRuta);

    List<Ruta> buscarPorFecha(LocalDate fecha);

    List<Ruta> buscarPorEstado(EstadoRuta estado);

    List<Ruta> listarTodos();

    void cambiarEstado(long id, EstadoRuta estado);

}
