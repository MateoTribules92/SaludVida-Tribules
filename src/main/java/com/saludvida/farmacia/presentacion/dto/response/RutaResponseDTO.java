package com.saludvida.farmacia.presentacion.dto.response;


import java.time.LocalDate;
import java.time.LocalDateTime;

import com.saludvida.farmacia.dominio.entidades.EstadoRuta;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RutaResponseDTO {

    private long idRuta;
    private String codigoRuta;
    private LocalDate fechaRuta;
    private String zona;
    private long idVehiculo;
    private long idDistribuidor;
    private EstadoRuta estado;
    private String observacion;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
}