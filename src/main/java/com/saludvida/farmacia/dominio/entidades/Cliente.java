package com.saludvida.farmacia.dominio.entidades;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Cliente {
	
	 private final long idCliente;
	    private final TipoCliente tipoCliente;
	    private final String identificacion;
	    private final String nombres;
	    private final String correo;
	    private final String telefono;
	    private final String direccion;
	    private final String ciudad;
	    private final String zona;
	    private final BigDecimal latitud;
	    private final BigDecimal longitud;
	    private final ClasificacionCliente clasificacion;
	    private final boolean activo;
	    private final LocalDateTime fechaCreacion;
	    private final LocalDateTime fechaActualizacion;

	    public Cliente(long idCliente, TipoCliente tipoCliente,
	                   String identificacion, String nombres, String correo,
	                   String telefono, String direccion, String ciudad,
	                   String zona, BigDecimal latitud, BigDecimal longitud,
	                   ClasificacionCliente clasificacion, boolean activo,
	                   LocalDateTime fechaCreacion,
	                   LocalDateTime fechaActualizacion) {
	        this.idCliente = idCliente;
	        this.tipoCliente = tipoCliente;
	        this.identificacion = identificacion;
	        this.nombres = nombres;
	        this.correo = correo;
	        this.telefono = telefono;
	        this.direccion = direccion;
	        this.ciudad = ciudad;
	        this.zona = zona;
	        this.latitud = latitud;
	        this.longitud = longitud;
	        this.clasificacion = clasificacion;
	        this.activo = activo;
	        this.fechaCreacion = fechaCreacion;
	        this.fechaActualizacion = fechaActualizacion;
	    }

	    public long getIdCliente() { return idCliente; }
	    public TipoCliente getTipoCliente() { return tipoCliente; }
	    public String getIdentificacion() { return identificacion; }
	    public String getNombres() { return nombres; }
	    public String getCorreo() { return correo; }
	    public String getTelefono() { return telefono; }
	    public String getDireccion() { return direccion; }
	    public String getCiudad() { return ciudad; }
	    public String getZona() { return zona; }
	    public BigDecimal getLatitud() { return latitud; }
	    public BigDecimal getLongitud() { return longitud; }
	    public ClasificacionCliente getClasificacion() { return clasificacion; }
	    public boolean isActivo() { return activo; }
	    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
	    public LocalDateTime getFechaActualizacion() { return fechaActualizacion; }
}
