package com.saludvida.farmacia.dominio.entidades;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Producto {
	
	private final long idProducto;
    private final String codigo;
    private final String nombre;
    private final String descripcion;
    private final long idCategoria;
    private final long idProveedor;
    private final BigDecimal precio;
    private final LocalDate fechaCaducidad;
    private final boolean activo;
    private final LocalDateTime fechaCreacion;
    private final LocalDateTime fechaActualizacion;

    public Producto(long idProducto, String codigo, String nombre,
                    String descripcion, long idCategoria, long idProveedor,
                    BigDecimal precio, LocalDate fechaCaducidad,
                    boolean activo, LocalDateTime fechaCreacion,
                    LocalDateTime fechaActualizacion) {
        this.idProducto = idProducto;
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.idCategoria = idCategoria;
        this.idProveedor = idProveedor;
        this.precio = precio;
        this.fechaCaducidad = fechaCaducidad;
        this.activo = activo;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
    }

    public long getIdProducto() { return idProducto; }
    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public long getIdCategoria() { return idCategoria; }
    public long getIdProveedor() { return idProveedor; }
    public BigDecimal getPrecio() { return precio; }
    public LocalDate getFechaCaducidad() { return fechaCaducidad; }
    public boolean isActivo() { return activo; }
    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public LocalDateTime getFechaActualizacion() { return fechaActualizacion; }
}
