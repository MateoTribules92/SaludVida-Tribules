package com.saludvida.farmacia.presentacion.dto.response;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FarmaciaResponseDTO {

    private long idFarmacia;
    private String nombre;
    private String direccion;
    private String ciudad;
    private String zona;
    private BigDecimal latitud;
    private BigDecimal longitud;
    private Boolean activo;
}