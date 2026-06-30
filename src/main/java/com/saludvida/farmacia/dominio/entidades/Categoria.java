package com.saludvida.farmacia.dominio.entidades;

public class Categoria {
	
	private final long idCategoria;
    private final String nombre;
    private final String descripcion;
    private final boolean activo;

    public Categoria(long idCategoria, String nombre,
                     String descripcion, boolean activo) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.activo = activo;
    }

    public long getIdCategoria() { return idCategoria; }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public boolean isActivo() { return activo; }

}
