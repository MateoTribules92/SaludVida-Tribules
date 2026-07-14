package com.saludvida.farmacia.aplicacion.casosuso.entradas;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.saludvida.farmacia.dominio.entidades.Producto;

public interface IProductoUseCase {
	
    Producto crear(Producto producto);

    Producto actualizar(Producto producto);

    Optional<Producto> buscarPorId(long id);

    Optional<Producto> buscarPorCodigo(String codigo);

    List<Producto> listarTodos();

    List<Producto> listarActivos();

    List<Producto> buscarPorCategoria(long idCategoria);

    List<Producto> buscarPorProveedor(long idProveedor);

    List<Producto> buscarVencidos(LocalDate fecha);

    List<Producto> buscarProximosACaducar(LocalDate fechaLimite);

    void activar(long id);

    void desactivar(long id);


}
