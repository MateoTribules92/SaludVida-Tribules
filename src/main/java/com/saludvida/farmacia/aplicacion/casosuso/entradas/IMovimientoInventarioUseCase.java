package com.saludvida.farmacia.aplicacion.casosuso.entradas;

import java.util.List;
import java.util.Optional;

import com.saludvida.farmacia.dominio.entidades.MovimientoInventario;
import com.saludvida.farmacia.dominio.entidades.TipoMovimiento;

public interface IMovimientoInventarioUseCase {
	
	 MovimientoInventario registrar(MovimientoInventario movimientoInventario);

	    Optional<MovimientoInventario> buscarPorId(long id);

	    List<MovimientoInventario> buscarPorInventario(long idInventario);

	    List<MovimientoInventario> buscarPorUsuario(long idUsuario);

	    List<MovimientoInventario> buscarPorTipoMovimiento(TipoMovimiento tipoMovimiento);

	    List<MovimientoInventario> listarTodos();

}
