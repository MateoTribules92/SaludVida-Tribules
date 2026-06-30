package com.saludvida.farmacia.dominio.entidades;

public class Proveedor {

	 private final long idProveedor;
	    private final String nombre;
	    private final String ruc;
	    private final String telefono;
	    private final String correo;
	    private final String direccion;
	    private final boolean activo;

	    public Proveedor(long idProveedor, String nombre, String ruc,
	                     String telefono, String correo, String direccion,
	                     boolean activo) {
	        this.idProveedor = idProveedor;
	        this.nombre = nombre;
	        this.ruc = ruc;
	        this.telefono = telefono;
	        this.correo = correo;
	        this.direccion = direccion;
	        this.activo = activo;
	    }

	    public long getIdProveedor() { return idProveedor; }
	    public String getNombre() { return nombre; }
	    public String getRuc() { return ruc; }
	    public String getTelefono() { return telefono; }
	    public String getCorreo() { return correo; }
	    public String getDireccion() { return direccion; }
	    public boolean isActivo() { return activo; }
}
