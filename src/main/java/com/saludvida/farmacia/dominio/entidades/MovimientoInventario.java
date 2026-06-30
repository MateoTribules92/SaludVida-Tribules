package com.saludvida.farmacia.dominio.entidades;

import java.time.LocalDateTime;

public class MovimientoInventario {
	
	private final long idMovimiento;
    private final long idInventario;
    private final Long  idUsuario;
    private final TipoMovimiento tipoMovimiento;
    private final int cantidad;
    private final String motivo;
    private final LocalDateTime fechaMovimiento;

    public MovimientoInventario(long idMovimiento, long idInventario,
    		Long  idUsuario, TipoMovimiento tipoMovimiento,
                                int cantidad, String motivo,
                                LocalDateTime fechaMovimiento) {
        this.idMovimiento = idMovimiento;
        this.idInventario = idInventario;
        this.idUsuario = idUsuario;
        this.tipoMovimiento = tipoMovimiento;
        this.cantidad = cantidad;
        this.motivo = motivo;
        this.fechaMovimiento = fechaMovimiento;
    }

    public long getIdMovimiento() { return idMovimiento; }
    public long getIdInventario() { return idInventario; }
    public Long  getIdUsuario() { return idUsuario; }
    public TipoMovimiento getTipoMovimiento() { return tipoMovimiento; }
    public int getCantidad() { return cantidad; }
    public String getMotivo() { return motivo; }
    public LocalDateTime getFechaMovimiento() { return fechaMovimiento; }
}
