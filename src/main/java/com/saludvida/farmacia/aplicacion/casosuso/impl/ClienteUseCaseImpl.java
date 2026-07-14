package com.saludvida.farmacia.aplicacion.casosuso.impl;

import java.util.List;
import java.util.Optional;

import com.saludvida.farmacia.aplicacion.casosuso.entradas.IClienteUseCase;
import com.saludvida.farmacia.dominio.entidades.ClasificacionCliente;
import com.saludvida.farmacia.dominio.entidades.Cliente;
import com.saludvida.farmacia.dominio.repositorio.IClienteRepositorio;

public final class ClienteUseCaseImpl implements IClienteUseCase {

    private final IClienteRepositorio clienteRepositorio;

    public ClienteUseCaseImpl(IClienteRepositorio clienteRepositorio) {
        this.clienteRepositorio = clienteRepositorio;
    }

    @Override
    public Cliente crear(Cliente cliente) {
        return clienteRepositorio.guardar(cliente);
    }

    @Override
    public Cliente actualizar(Cliente cliente) {
        return clienteRepositorio.guardar(cliente);
    }

    @Override
    public Optional<Cliente> buscarPorId(long id) {
        return clienteRepositorio.buscarPorId(id);
    }

    @Override
    public Optional<Cliente> buscarPorIdentificacion(String identificacion) {
        return clienteRepositorio.buscarPorIdentificacion(identificacion);
    }

    @Override
    public List<Cliente> buscarPorClasificacion(ClasificacionCliente clasificacion) {
        return clienteRepositorio.buscarPorClasificacion(clasificacion);
    }

    @Override
    public List<Cliente> listarTodos() {
        return clienteRepositorio.listarTodos();
    }

    @Override
    public List<Cliente> listarActivos() {
        return clienteRepositorio.listarActivos();
    }

    @Override
    public void activar(long id) {
        clienteRepositorio.cambiarEstadoActivo(id, true);
    }

    @Override
    public void desactivar(long id) {
        clienteRepositorio.cambiarEstadoActivo(id, false);
    }
}