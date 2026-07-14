package com.saludvida.farmacia.presentacion.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.saludvida.farmacia.dominio.entidades.EstadoPedido;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoResponseDTO {

    private long idPedido;
    private String numeroPedido;
    private long idCliente;
    private long idFarmacia;
    private long idVendedor;
    private EstadoPedido estado;
    private BigDecimal total;
    private String direccionEntrega;
    private String observacion;
    private LocalDateTime fechaPedido;
    private LocalDateTime fechaActualizacion;
}