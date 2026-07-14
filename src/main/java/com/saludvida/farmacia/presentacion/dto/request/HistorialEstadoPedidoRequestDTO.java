package com.saludvida.farmacia.presentacion.dto.request;

import com.saludvida.farmacia.dominio.entidades.EstadoPedido;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistorialEstadoPedidoRequestDTO {

    private long idPedido;
    private EstadoPedido estadoAnterior;
    private EstadoPedido estadoNuevo;
    private Long idUsuario;
    private String observacion;
}