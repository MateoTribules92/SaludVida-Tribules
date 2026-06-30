package com.saludvida.farmacia.dominio.entidades;

import java.math.BigDecimal;

public class Farmacia {
	
	private final long idFarmacia;
    private final String nombre;
    private final String direccion;
    private final String ciudad;
    private final String zona;
    private final BigDecimal latitud;
    private final BigDecimal longitud;
    private final boolean activo;

    public Farmacia(long idFarmacia, String nombre, String direccion,
                    String ciudad, String zona, BigDecimal latitud,
                    BigDecimal longitud, boolean activo) {
        this.idFarmacia = idFarmacia;
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.zona = zona;
        this.latitud = latitud;
        this.longitud = longitud;
        this.activo = activo;
    }

    public long getIdFarmacia() { return idFarmacia; }
    public String getNombre() { return nombre; }
    public String getDireccion() { return direccion; }
    public String getCiudad() { return ciudad; }
    public String getZona() { return zona; }
    public BigDecimal getLatitud() { return latitud; }
    public BigDecimal getLongitud() { return longitud; }
    public boolean isActivo() { return activo; }
}
