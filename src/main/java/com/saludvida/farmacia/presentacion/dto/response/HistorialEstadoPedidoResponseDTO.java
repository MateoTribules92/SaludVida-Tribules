package com.saludvida.farmacia.presentacion.dto.response;

import java.time.LocalDateTime;

import com.saludvida.farmacia.dominio.entidades.EstadoPedido;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistorialEstadoPedidoResponseDTO {

    private long idHistorial;
    private long idPedido;
    private EstadoPedido estadoAnterior;
    private EstadoPedido estadoNuevo;
    private Long idUsuario;
    private String observacion;
    private LocalDateTime fechaRegistro;
}
