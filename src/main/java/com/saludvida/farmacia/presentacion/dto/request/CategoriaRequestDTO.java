package com.saludvida.farmacia.presentacion.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaRequestDTO {

    private String nombre;
    private String descripcion;
    private Boolean activo;
}