package com.saludvida.farmacia.infraestructura.persistencia.jpa;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "roles", schema = "saludvida")

public class RolJpa {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id_rol")
	    private Integer idRol;

	    @Column(nullable = false, unique = true, length = 40)
	    private String codigo;

	    @Column(nullable = false, length = 80)
	    private String nombre;

	    @Column(columnDefinition = "TEXT")
	    private String descripcion;

	    @Column(nullable = false)
	    private Boolean activo;
}
