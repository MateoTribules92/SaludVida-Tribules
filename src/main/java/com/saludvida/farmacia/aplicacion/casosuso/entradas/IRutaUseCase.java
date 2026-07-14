package com.saludvida.farmacia.aplicacion.casosuso.entradas;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.saludvida.farmacia.dominio.entidades.EstadoRuta;
import com.saludvida.farmacia.dominio.entidades.Ruta;

public interface IRutaUseCase {
	
	Ruta crear(Ruta ruta);

    Ruta actualizar(Ruta ruta);

    Optional<Ruta> buscarPorId(long id);

    Optional<Ruta> buscarPorCodigoRuta(String codigoRuta);

    List<Ruta> buscarPorFecha(LocalDate fecha);

    List<Ruta> buscarPorEstado(EstadoRuta estado);

    List<Ruta> buscarPorZona(String zona);

    List<Ruta> listarTodos();

    boolean existeRutaActivaPorVehiculoYFecha(long idVehiculo, LocalDate fecha);

    boolean existeRutaActivaPorDistribuidorYFecha(long idDistribuidor, LocalDate fecha);

    void cambiarEstado(long id, EstadoRuta estado);

}
