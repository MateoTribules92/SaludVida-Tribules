package com.saludvida.farmacia.presentacion.dto.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventarioResponseDTO {

    private long idInventario;
    private long idFarmacia;
    private long idProducto;
    private Integer stock;
    private Integer stockMinimo;
    private LocalDateTime fechaActualizacion;
}
