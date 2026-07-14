package com.saludvida.farmacia.presentacion.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoResponseDTO {

    private long idProducto;
    private String codigo;
    private String nombre;
    private String descripcion;
    private long idCategoria;
    private long idProveedor;
    private BigDecimal precio;
    private LocalDate fechaCaducidad;
    private Boolean activo;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
}