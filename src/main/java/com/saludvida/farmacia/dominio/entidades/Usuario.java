package com.saludvida.farmacia.dominio.entidades;

import java.time.LocalDateTime;

public class Usuario {

	private final long idUsuario;
    private final long idRol;
    private final String nombres;
    private final String correo;
    private final String passwordHash;
    private final boolean activo;
    private final LocalDateTime fechaCreacion;
    private final LocalDateTime fechaActualizacion;

    public Usuario(long idUsuario, long idRol, String nombres,
                   String correo, String passwordHash, boolean activo,
                   LocalDateTime fechaCreacion,
                   LocalDateTime fechaActualizacion) {
        this.idUsuario = idUsuario;
        this.idRol = idRol;
        this.nombres = nombres;
        this.correo = correo;
        this.passwordHash = passwordHash;
        this.activo = activo;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
    }

    public long getIdUsuario() { return idUsuario; }
    public long getIdRol() { return idRol; }
    public String getNombres() { return nombres; }
    public String getCorreo() { return correo; }
    public String getPasswordHash() { return passwordHash; }
    public boolean isActivo() { return activo; }
    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public LocalDateTime getFechaActualizacion() { return fechaActualizacion; }
}