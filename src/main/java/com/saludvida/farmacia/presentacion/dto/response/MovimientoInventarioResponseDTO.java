package com.saludvida.farmacia.presentacion.dto.response;

import java.time.LocalDateTime;

import com.saludvida.farmacia.dominio.entidades.TipoMovimiento;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovimientoInventarioResponseDTO {

    private long idMovimiento;
    private long idInventario;
    private Long idUsuario;
    private TipoMovimiento tipoMovimiento;
    private Integer cantidad;
    private String motivo;
    private LocalDateTime fechaMovimiento;
}