package com.saludvida.farmacia.dominio.entidades;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Ruta {
	
	 private final long idRuta;
	    private final String codigoRuta;
	    private final LocalDate fechaRuta;
	    private final String zona;
	    private final long idVehiculo;
	    private final long idDistribuidor;
	    private final EstadoRuta estado;
	    private final String observacion;
	    private final LocalDateTime fechaCreacion;
	    private final LocalDateTime fechaActualizacion;

	    public Ruta(long idRuta, String codigoRuta, LocalDate fechaRuta,
	                String zona, long idVehiculo, long idDistribuidor,
	                EstadoRuta estado, String observacion,
	                LocalDateTime fechaCreacion,
	                LocalDateTime fechaActualizacion) {
	        this.idRuta = idRuta;
	        this.codigoRuta = codigoRuta;
	        this.fechaRuta = fechaRuta;
	        this.zona = zona;
	        this.idVehiculo = idVehiculo;
	        this.idDistribuidor = idDistribuidor;
	        this.estado = estado;
	        this.observacion = observacion;
	        this.fechaCreacion = fechaCreacion;
	        this.fechaActualizacion = fechaActualizacion;
	    }

	    public long getIdRuta() { return idRuta; }
	    public String getCodigoRuta() { return codigoRuta; }
	    public LocalDate getFechaRuta() { return fechaRuta; }
	    public String getZona() { return zona; }
	    public long getIdVehiculo() { return idVehiculo; }
	    public long getIdDistribuidor() { return idDistribuidor; }
	    public EstadoRuta getEstado() { return estado; }
	    public String getObservacion() { return observacion; }
	    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
	    public LocalDateTime getFechaActualizacion() { return fechaActualizacion; }
	
}
