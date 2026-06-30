package com.saludvida.farmacia.dominio.repositorio;

import java.util.List;
import java.util.Optional;
import com.saludvida.farmacia.dominio.entidades.Inventario;

public interface IInventarioRepositorio {
	
	 Inventario guardar(Inventario inventario);

	    Optional<Inventario> buscarPorId(long id);

	    Optional<Inventario> buscarPorFarmaciaYProducto(
	            long idFarmacia,
	            long idProducto);

	    List<Inventario> buscarPorFarmacia(long idFarmacia);

	    List<Inventario> listarTodos();

	    List<Inventario> buscarConStockBajo();

}
