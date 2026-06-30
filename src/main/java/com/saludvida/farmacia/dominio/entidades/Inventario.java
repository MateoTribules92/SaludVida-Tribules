package com.saludvida.farmacia.dominio.entidades;

import java.time.LocalDateTime;

public class Inventario {

	  private final long idInventario;
	    private final long idFarmacia;
	    private final long idProducto;
	    private final int stock;
	    private final int stockMinimo;
	    private final LocalDateTime fechaActualizacion;

	    public Inventario(long idInventario, long idFarmacia, long idProducto,
	                      int stock, int stockMinimo,
	                      LocalDateTime fechaActualizacion) {
	        this.idInventario = idInventario;
	        this.idFarmacia = idFarmacia;
	        this.idProducto = idProducto;
	        this.stock = stock;
	        this.stockMinimo = stockMinimo;
	        this.fechaActualizacion = fechaActualizacion;
	    }

	    public long getIdInventario() { return idInventario; }
	    public long getIdFarmacia() { return idFarmacia; }
	    public long getIdProducto() { return idProducto; }
	    public int getStock() { return stock; }
	    public int getStockMinimo() { return stockMinimo; }
	    public LocalDateTime getFechaActualizacion() { return fechaActualizacion; }
	
}
