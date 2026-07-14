package com.saludvida.farmacia.aplicacion.casosuso.entradas;

import java.util.List;
import java.util.Optional;

import com.saludvida.farmacia.dominio.entidades.Inventario;

public interface IInventarioUseCase {
	
	 Inventario guardar(Inventario inventario);

	    Optional<Inventario> buscarPorId(long id);

	    Optional<Inventario> buscarPorFarmaciaYProducto(long idFarmacia, long idProducto);

	    List<Inventario> buscarPorFarmacia(long idFarmacia);

	    List<Inventario> buscarPorProducto(long idProducto);

	    List<Inventario> buscarConStockBajo();

	    List<Inventario> listarTodos();

}
