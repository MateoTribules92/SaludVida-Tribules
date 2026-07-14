package com.saludvida.farmacia.presentacion.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RolResponseDTO {

    private long idRol;
    private String codigo;
    private String nombre;
    private String descripcion;
    private Boolean activo;
}