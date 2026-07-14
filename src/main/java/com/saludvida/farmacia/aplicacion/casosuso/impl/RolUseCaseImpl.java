package com.saludvida.farmacia.aplicacion.casosuso.impl;

import java.util.List;
import java.util.Optional;

import com.saludvida.farmacia.aplicacion.casosuso.entradas.IRolUseCase;
import com.saludvida.farmacia.dominio.entidades.Rol;
import com.saludvida.farmacia.dominio.repositorio.IRolRepositorio;

public class RolUseCaseImpl implements IRolUseCase{
	
	 private final IRolRepositorio rolRepositorio;


	 public RolUseCaseImpl(IRolRepositorio rolRepositorio) {
	        this.rolRepositorio = rolRepositorio;
	    }

	 @Override
	    public Rol crear(Rol rol) {
	        return rolRepositorio.guardar(rol);
	    }

	 @Override
	    public Rol actualizar(Rol rol) {
	        return rolRepositorio.guardar(rol);
	    }

	    @Override
	    public Optional<Rol> buscarPorId(long id) {
	        return rolRepositorio.buscarPorId(id);
	    }

	    @Override
	    public Optional<Rol> buscarPorCodigo(String codigo) {
	        return rolRepositorio.buscarPorCodigo(codigo);
	    }

	    @Override
	    public List<Rol> listarTodos() {
	        return rolRepositorio.listarTodos();
	    }

	    @Override
	    public List<Rol> listarActivos() {
	        return rolRepositorio.listarActivos();
	    }

	    @Override
	    public void activar(long id) {
	        rolRepositorio.cambiarEstadoActivo(id, true);
	    }

	    @Override
	    public void desactivar(long id) {
	        rolRepositorio.cambiarEstadoActivo(id, false);
	    }
	    
	    
	
	

}
