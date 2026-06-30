package com.saludvida.farmacia.dominio.entidades;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Pedido {

	 private final long idPedido;
	    private final String numeroPedido;
	    private final long idCliente;
	    private final long idFarmacia;
	    private final long idVendedor;
	    private final EstadoPedido estado;
	    private final BigDecimal total;
	    private final String direccionEntrega;
	    private final String observacion;
	    private final LocalDateTime fechaPedido;
	    private final LocalDateTime fechaActualizacion;

	    public Pedido(long idPedido, String numeroPedido, long idCliente,
	                  long idFarmacia, long idVendedor, EstadoPedido estado,
	                  BigDecimal total, String direccionEntrega,
	                  String observacion, LocalDateTime fechaPedido,
	                  LocalDateTime fechaActualizacion) {
	        this.idPedido = idPedido;
	        this.numeroPedido = numeroPedido;
	        this.idCliente = idCliente;
	        this.idFarmacia = idFarmacia;
	        this.idVendedor = idVendedor;
	        this.estado = estado;
	        this.total = total;
	        this.direccionEntrega = direccionEntrega;
	        this.observacion = observacion;
	        this.fechaPedido = fechaPedido;
	        this.fechaActualizacion = fechaActualizacion;
	    }

	    public long getIdPedido() { return idPedido; }
	    public String getNumeroPedido() { return numeroPedido; }
	    public long getIdCliente() { return idCliente; }
	    public long getIdFarmacia() { return idFarmacia; }
	    public long getIdVendedor() { return idVendedor; }
	    public EstadoPedido getEstado() { return estado; }
	    public BigDecimal getTotal() { return total; }
	    public String getDireccionEntrega() { return direccionEntrega; }
	    public String getObservacion() { return observacion; }
	    public LocalDateTime getFechaPedido() { return fechaPedido; }
	    public LocalDateTime getFechaActualizacion() { return fechaActualizacion; }
}
