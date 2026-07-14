package com.saludvida.farmacia.infraestructura.configuracion;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.saludvida.farmacia.dominio.repositorio.*;
import com.saludvida.farmacia.infraestructura.persistencia.adaptadores.*;
import com.saludvida.farmacia.infraestructura.persistencia.mapeadores.*;
import com.saludvida.farmacia.infraestructura.repositorios.*;

@Configuration
public class RepositorioConfig {

    @Bean
    IRolRepositorio rolRepositorio(IRolJpaRepository jpaRepository, IRolJpaMapper mapper) {
        return new RolRepositorioImpl(jpaRepository, mapper);
    }

    @Bean
    IUsuarioRepositorio usuarioRepositorio(IUsuarioJpaRepository jpaRepository, IUsuarioJpaMapper mapper) {
        return new UsuarioRepositorioImpl(jpaRepository, mapper);
    }

    @Bean
    ICategoriaRepositorio categoriaRepositorio(ICategoriaJpaRepository jpaRepository, ICategoriaJpaMapper mapper) {
        return new CategoriaRepositorioImpl(jpaRepository, mapper);
    }

    @Bean
    IProveedorRepositorio proveedorRepositorio(IProveedorJpaRepository jpaRepository, IProveedorJpaMapper mapper) {
        return new ProveedorRepositorioImpl(jpaRepository, mapper);
    }

    @Bean
    IFarmaciaRepositorio farmaciaRepositorio(IFarmaciaJpaRepository jpaRepository, IFarmaciaJpaMapper mapper) {
        return new FarmaciaRepositorioImpl(jpaRepository, mapper);
    }

    @Bean
    IProductoRepositorio productoRepositorio(IProductoJpaRepository jpaRepository, IProductoJpaMapper mapper) {
        return new ProductoRepositorioImpl(jpaRepository, mapper);
    }

    @Bean
    IInventarioRepositorio inventarioRepositorio(IInventarioJpaRepository jpaRepository, IInventarioJpaMapper mapper) {
        return new InventarioRepositorioImpl(jpaRepository, mapper);
    }

    @Bean
    IMovimientoInventarioRepositorio movimientoInventarioRepositorio(
            IMovimientoInventarioJpaRepository jpaRepository,
            IMovimientoInventarioJpaMapper mapper) {
        return new MovimientoInventarioRepositorioImpl(jpaRepository, mapper);
    }

    @Bean
    IClienteRepositorio clienteRepositorio(IClienteJpaRepository jpaRepository, IClienteJpaMapper mapper) {
        return new ClienteRepositorioImpl(jpaRepository, mapper);
    }

    @Bean
    IPedidoRepositorio pedidoRepositorio(IPedidoJpaRepository jpaRepository, IPedidoJpaMapper mapper) {
        return new PedidoRepositorioImpl(jpaRepository, mapper);
    }

    @Bean
    IDetallePedidoRepositorio detallePedidoRepositorio(
            IDetallePedidoJpaRepository jpaRepository,
            IDetallePedidoJpaMapper mapper) {
        return new DetallePedidoRepositorioImpl(jpaRepository, mapper);
    }

    @Bean
    IHistorialEstadoPedidoRepositorio historialEstadoPedidoRepositorio(
            IHistorialEstadoPedidoJpaRepository jpaRepository,
            IHistorialEstadoPedidoJpaMapper mapper) {
        return new HistorialEstadoPedidoRepositorioImpl(jpaRepository, mapper);
    }

    @Bean
    IVehiculoRepositorio vehiculoRepositorio(IVehiculoJpaRepository jpaRepository, IVehiculoJpaMapper mapper) {
        return new VehiculoRepositorioImpl(jpaRepository, mapper);
    }

    @Bean
    IRutaRepositorio rutaRepositorio(IRutaJpaRepository jpaRepository, IRutaJpaMapper mapper) {
        return new RutaRepositorioImpl(jpaRepository, mapper);
    }

    @Bean
    IRutaPedidoRepositorio rutaPedidoRepositorio(IRutaPedidoJpaRepository jpaRepository, IRutaPedidoJpaMapper mapper) {
        return new RutaPedidoRepositorioImpl(jpaRepository, mapper);
    }
}