package com.saludvida.farmacia.presentacion.dto.request;

import java.time.LocalDate;

import com.saludvida.farmacia.dominio.entidades.EstadoRuta;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RutaRequestDTO {

    private String codigoRuta;
    private LocalDate fechaRuta;
    private String zona;
    private long idVehiculo;
    private long idDistribuidor;
    private EstadoRuta estado;
    private String observacion;
}