package com.saludvida.farmacia.dominio.entidades;

import java.math.BigDecimal;

public class Vehiculo {
	
	 private final long idVehiculo;
	    private final String placa;
	    private final String descripcion;
	    private final int capacidadPedidos;
	    private final BigDecimal capacidadKg;
	    private final EstadoVehiculo estado;
	    private final boolean activo;

	    public Vehiculo(long idVehiculo, String placa, String descripcion,
	                    int capacidadPedidos, BigDecimal capacidadKg,
	                    EstadoVehiculo estado, boolean activo) {
	        this.idVehiculo = idVehiculo;
	        this.placa = placa;
	        this.descripcion = descripcion;
	        this.capacidadPedidos = capacidadPedidos;
	        this.capacidadKg = capacidadKg;
	        this.estado = estado;
	        this.activo = activo;
	    }

	    public long getIdVehiculo() { return idVehiculo; }
	    public String getPlaca() { return placa; }
	    public String getDescripcion() { return descripcion; }
	    public int getCapacidadPedidos() { return capacidadPedidos; }
	    public BigDecimal getCapacidadKg() { return capacidadKg; }
	    public EstadoVehiculo getEstado() { return estado; }
	    public boolean isActivo() { return activo; }

}
