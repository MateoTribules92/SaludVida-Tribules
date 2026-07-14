package com.saludvida.farmacia.presentacion.dto.request;

import java.math.BigDecimal;

import com.saludvida.farmacia.dominio.entidades.EstadoVehiculo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehiculoRequestDTO {

    private String placa;
    private String descripcion;
    private Integer capacidadPedidos;
    private BigDecimal capacidadKg;
    private EstadoVehiculo estado;
    private Boolean activo;
}