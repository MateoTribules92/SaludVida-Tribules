package com.saludvida.farmacia.presentacion.dto.request;

import java.math.BigDecimal;

import com.saludvida.farmacia.dominio.entidades.ClasificacionCliente;
import com.saludvida.farmacia.dominio.entidades.TipoCliente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteRequestDTO {

    private TipoCliente tipoCliente;
    private String identificacion;
    private String nombres;
    private String correo;
    private String telefono;
    private String direccion;
    private String ciudad;
    private String zona;
    private BigDecimal latitud;
    private BigDecimal longitud;
    private ClasificacionCliente clasificacion;
    private Boolean activo;
}