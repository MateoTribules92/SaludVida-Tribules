package com.saludvida.farmacia.presentacion.dto.request;

import java.math.BigDecimal;

import com.saludvida.farmacia.dominio.entidades.EstadoPedido;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoRequestDTO {

    private String numeroPedido;
    private long idCliente;
    private long idFarmacia;
    private long idVendedor;
    private EstadoPedido estado;
    private BigDecimal total;
    private String direccionEntrega;
    private String observacion;
}