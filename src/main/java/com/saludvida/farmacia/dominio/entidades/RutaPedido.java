package com.saludvida.farmacia.dominio.entidades;

import java.time.LocalDateTime;

public class RutaPedido {

	 private final long idRutaPedido;
	    private final long idRuta;
	    private final long idPedido;
	    private final int ordenEntrega;
	    private final LocalDateTime fechaAsignacion;

	    public RutaPedido(long idRutaPedido, long idRuta, long idPedido,
	                      int ordenEntrega, LocalDateTime fechaAsignacion) {
	        this.idRutaPedido = idRutaPedido;
	        this.idRuta = idRuta;
	        this.idPedido = idPedido;
	        this.ordenEntrega = ordenEntrega;
	        this.fechaAsignacion = fechaAsignacion;
	    }

	    public long getIdRutaPedido() { return idRutaPedido; }
	    public long getIdRuta() { return idRuta; }
	    public long getIdPedido() { return idPedido; }
	    public int getOrdenEntrega() { return ordenEntrega; }
	    public LocalDateTime getFechaAsignacion() { return fechaAsignacion; }
}
