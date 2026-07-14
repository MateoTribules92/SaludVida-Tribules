package com.saludvida.farmacia.presentacion.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRequestDTO {

    private long idRol;
    private String nombres;
    private String correo;
    private String passwordHash;
    private Boolean activo;
}
