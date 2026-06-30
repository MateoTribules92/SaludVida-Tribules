package com.saludvida.farmacia.infraestructura.persistencia.jpa;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categorias", schema = "saludvida")
public class CategoriaJpa {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id_categoria")
	    private Integer idCategoria;

	    @Column(nullable = false, unique = true, length = 100)
	    private String nombre;

	    @Column(columnDefinition = "TEXT")
	    private String descripcion;

	    @Column(nullable = false)
	    private Boolean activo;

}
