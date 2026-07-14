package com.saludvida.farmacia.infraestructura.configuracion;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.saludvida.farmacia.aplicacion.casosuso.entradas.*;
import com.saludvida.farmacia.aplicacion.casosuso.impl.*;
import com.saludvida.farmacia.dominio.repositorio.*;

@Configuration
public class UseCaseConfig {

    @Bean
    IRolUseCase rolUseCase(IRolRepositorio repositorio) {
        return new RolUseCaseImpl(repositorio);
    }

    @Bean
    IUsuarioUseCase usuarioUseCase(IUsuarioRepositorio repositorio) {
        return new UsuarioUseCaseImpl(repositorio);
    }

    @Bean
    ICategoriaUseCase categoriaUseCase(ICategoriaRepositorio repositorio) {
        return new CategoriaUseCaseImpl(repositorio);
    }

    @Bean
    IProveedorUseCase proveedorUseCase(IProveedorRepositorio repositorio) {
        return new ProveedorUseCaseImpl(repositorio);
    }

    @Bean
    IFarmaciaUseCase farmaciaUseCase(IFarmaciaRepositorio repositorio) {
        return new FarmaciaUseCaseImpl(repositorio);
    }

    @Bean
    IProductoUseCase productoUseCase(IProductoRepositorio repositorio) {
        return new ProductoUseCaseImpl(repositorio);
    }

    @Bean
    IInventarioUseCase inventarioUseCase(IInventarioRepositorio repositorio) {
        return new InventarioUseCaseImpl(repositorio);
    }

    @Bean
    IMovimientoInventarioUseCase movimientoInventarioUseCase(IMovimientoInventarioRepositorio repositorio) {
        return new MovimientoInventarioUseCaseImpl(repositorio);
    }

    @Bean
    IClienteUseCase clienteUseCase(IClienteRepositorio repositorio) {
        return new ClienteUseCaseImpl(repositorio);
    }

    @Bean
    IPedidoUseCase pedidoUseCase(IPedidoRepositorio repositorio) {
        return new PedidoUseCaseImpl(repositorio);
    }

    @Bean
    IDetallePedidoUseCase detallePedidoUseCase(IDetallePedidoRepositorio repositorio) {
        return new DetallePedidoUseCaseImpl(repositorio);
    }

    @Bean
    IHistorialEstadoPedidoUseCase historialEstadoPedidoUseCase(IHistorialEstadoPedidoRepositorio repositorio) {
        return new HistorialEstadoPedidoUseCaseImpl(repositorio);
    }

    @Bean
    IVehiculoUseCase vehiculoUseCase(IVehiculoRepositorio repositorio) {
        return new VehiculoUseCaseImpl(repositorio);
    }

    @Bean
    IRutaUseCase rutaUseCase(IRutaRepositorio repositorio) {
        return new RutaUseCaseImpl(repositorio);
    }

    @Bean
    IRutaPedidoUseCase rutaPedidoUseCase(IRutaPedidoRepositorio repositorio) {
        return new RutaPedidoUseCaseImpl(repositorio);
    }
}