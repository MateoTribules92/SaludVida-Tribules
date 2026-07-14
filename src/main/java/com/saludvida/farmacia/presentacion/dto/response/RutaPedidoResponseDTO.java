package com.saludvida.farmacia.presentacion.dto.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RutaPedidoResponseDTO {

    private long idRutaPedido;
    private long idRuta;
    private long idPedido;
    private Integer ordenEntrega;
    private LocalDateTime fechaAsignacion;
}