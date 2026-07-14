package com.saludvida.farmacia.presentacion.dto.request;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoRequestDTO {

    private String codigo;
    private String nombre;
    private String descripcion;
    private long idCategoria;
    private long idProveedor;
    private BigDecimal precio;
    private LocalDate fechaCaducidad;
    private Boolean activo;
}
