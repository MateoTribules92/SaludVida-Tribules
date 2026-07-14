package com.saludvida.farmacia.aplicacion.casosuso.impl;

import java.util.List;
import java.util.Optional;

import com.saludvida.farmacia.aplicacion.casosuso.entradas.IUsuarioUseCase;
import com.saludvida.farmacia.dominio.entidades.Usuario;
import com.saludvida.farmacia.dominio.repositorio.IUsuarioRepositorio;

public class UsuarioUseCaseImpl implements IUsuarioUseCase {
	
	 private final IUsuarioRepositorio usuarioRepositorio;

	    public UsuarioUseCaseImpl(IUsuarioRepositorio usuarioRepositorio) {
	        this.usuarioRepositorio = usuarioRepositorio;
	    }

	    @Override
	    public Usuario crear(Usuario usuario) {
	        return usuarioRepositorio.guardar(usuario);
	    }

	    @Override
	    public Usuario actualizar(Usuario usuario) {
	        return usuarioRepositorio.guardar(usuario);
	    }

	    @Override
	    public Optional<Usuario> buscarPorId(long id) {
	        return usuarioRepositorio.buscarPorId(id);
	    }

	    @Override
	    public Optional<Usuario> buscarPorCorreo(String correo) {
	        return usuarioRepositorio.buscarPorCorreo(correo);
	    }

	    @Override
	    public List<Usuario> listarTodos() {
	        return usuarioRepositorio.listarTodos();
	    }

	    @Override
	    public List<Usuario> listarActivos() {
	        return usuarioRepositorio.listarActivos();
	    }

	    @Override
	    public void activar(long id) {
	        usuarioRepositorio.cambiarEstadoActivo(id, true);
	    }

	    @Override
	    public void desactivar(long id) {
	        usuarioRepositorio.cambiarEstadoActivo(id, false);
	    }

}
