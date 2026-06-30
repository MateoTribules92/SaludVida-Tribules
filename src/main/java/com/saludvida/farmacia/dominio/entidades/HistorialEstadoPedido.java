package com.saludvida.farmacia.dominio.entidades;

import java.time.LocalDateTime;

public class HistorialEstadoPedido {
	
	 private final long idHistorial;
	    private final long idPedido;
	    private final EstadoPedido estadoAnterior;
	    private final EstadoPedido estadoNuevo;
	    private final Long  idUsuario;
	    private final String observacion;
	    private final LocalDateTime fechaRegistro;

	    public HistorialEstadoPedido(long idHistorial, long idPedido,
	                                 EstadoPedido estadoAnterior,
	                                 EstadoPedido estadoNuevo, Long  idUsuario,
	                                 String observacion,
	                                 LocalDateTime fechaRegistro) {
	        this.idHistorial = idHistorial;
	        this.idPedido = idPedido;
	        this.estadoAnterior = estadoAnterior;
	        this.estadoNuevo = estadoNuevo;
	        this.idUsuario = idUsuario;
	        this.observacion = observacion;
	        this.fechaRegistro = fechaRegistro;
	    }

	    public long getIdHistorial() { return idHistorial; }
	    public long getIdPedido() { return idPedido; }
	    public EstadoPedido getEstadoAnterior() { return estadoAnterior; }
	    public EstadoPedido getEstadoNuevo() { return estadoNuevo; }
	    public Long  getIdUsuario() { return idUsuario; }
	    public String getObservacion() { return observacion; }
	    public LocalDateTime getFechaRegistro() { return fechaRegistro; }

}
