package com.saludvida.farmacia.aplicacion.casosuso.impl;

import java.util.List;
import java.util.Optional;

import com.saludvida.farmacia.aplicacion.casosuso.entradas.ICategoriaUseCase;
import com.saludvida.farmacia.dominio.entidades.Categoria;
import com.saludvida.farmacia.dominio.repositorio.ICategoriaRepositorio;

public class CategoriaUseCaseImpl implements ICategoriaUseCase {

	private final ICategoriaRepositorio categoriaRepositorio;

	public CategoriaUseCaseImpl(ICategoriaRepositorio categoriaRepositorio) {
		this.categoriaRepositorio = categoriaRepositorio;
	}

	@Override
	public Categoria crear(Categoria categoria) {
		return categoriaRepositorio.guardar(categoria);
	}

	@Override
	public Categoria actualizar(Categoria categoria) {
		return categoriaRepositorio.guardar(categoria);
	}

	@Override
	public Optional<Categoria> buscarPorId(long id) {
		return categoriaRepositorio.buscarPorId(id);
	}

	@Override
	public Optional<Categoria> buscarPorNombre(String nombre) {
		return categoriaRepositorio.buscarPorNombre(nombre);
	}

	@Override
	public List<Categoria> listarTodos() {
		return categoriaRepositorio.listarTodos();
	}

	@Override
	public List<Categoria> listarActivos() {
		return categoriaRepositorio.listarActivos();
	}

	@Override
	public void activar(long id) {
		categoriaRepositorio.cambiarEstadoActivo(id, true);
	}

	@Override
	public void desactivar(long id) {
		categoriaRepositorio.cambiarEstadoActivo(id, false);
	}

}
