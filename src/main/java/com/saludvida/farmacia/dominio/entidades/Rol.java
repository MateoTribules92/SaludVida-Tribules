package com.saludvida.farmacia.dominio.entidades;

public class Rol {
	
	 private final long idRol;
	    private final String codigo;
	    private final String nombre;
	    private final String descripcion;
	    private final boolean activo;

	    public Rol(long idRol, String codigo, String nombre,
	               String descripcion, boolean activo) {
	        this.idRol = idRol;
	        this.codigo = codigo;
	        this.nombre = nombre;
	        this.descripcion = descripcion;
	        this.activo = activo;
	    }

	    public long getIdRol() { return idRol; }
	    public String getCodigo() { return codigo; }
	    public String getNombre() { return nombre; }
	    public String getDescripcion() { return descripcion; }
	    public boolean isActivo() { return activo; }

}
