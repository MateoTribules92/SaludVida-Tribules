package com.saludvida.farmacia.presentacion.dto.response;

import java.math.BigDecimal;

import com.saludvida.farmacia.dominio.entidades.EstadoVehiculo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehiculoResponseDTO {

    private long idVehiculo;
    private String placa;
    private String descripcion;
    private Integer capacidadPedidos;
    private BigDecimal capacidadKg;
    private EstadoVehiculo estado;
    private Boolean activo;
}