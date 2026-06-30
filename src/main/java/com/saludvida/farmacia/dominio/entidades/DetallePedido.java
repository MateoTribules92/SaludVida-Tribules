package com.saludvida.farmacia.dominio.entidades;

import java.math.BigDecimal;

public class DetallePedido {
	
	private final long idDetalle;
    private final long idPedido;
    private final long idProducto;
    private final int cantidad;
    private final BigDecimal precioUnitario;
    private final BigDecimal subtotal;

    public DetallePedido(long idDetalle, long idPedido, long idProducto,
                         int cantidad, BigDecimal precioUnitario,
                         BigDecimal subtotal) {
        this.idDetalle = idDetalle;
        this.idPedido = idPedido;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subtotal = subtotal;
    }

    public long getIdDetalle() { return idDetalle; }
    public long getIdPedido() { return idPedido; }
    public long getIdProducto() { return idProducto; }
    public int getCantidad() { return cantidad; }
    public BigDecimal getPrecioUnitario() { return precioUnitario; }
    public BigDecimal getSubtotal() { return subtotal; }
}
