package com.saludvida.farmacia.presentacion.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProveedorRequestDTO {

    private String nombre;
    private String ruc;
    private String telefono;
    private String correo;
    private String direccion;
    private Boolean activo;
}