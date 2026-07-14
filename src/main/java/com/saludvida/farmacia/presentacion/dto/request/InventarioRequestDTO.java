package com.saludvida.farmacia.presentacion.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventarioRequestDTO {

    private long idFarmacia;
    private long idProducto;
    private Integer stock;
    private Integer stockMinimo;
}