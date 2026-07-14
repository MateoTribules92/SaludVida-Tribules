package com.saludvida.farmacia.presentacion.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RutaPedidoRequestDTO {

    private long idRuta;
    private long idPedido;
    private Integer ordenEntrega;
}
