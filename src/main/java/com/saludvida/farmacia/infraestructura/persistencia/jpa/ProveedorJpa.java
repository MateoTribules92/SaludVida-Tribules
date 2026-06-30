package com.saludvida.farmacia.infraestructura.persistencia.jpa;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "proveedores", schema = "saludvida")
public class ProveedorJpa {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id_proveedor")
	    private Integer idProveedor;

	    @Column(nullable = false, length = 150)
	    private String nombre;

	    @Column(unique = true, length = 20)
	    private String ruc;

	    @Column(length = 30)
	    private String telefono;

	    @Column(length = 150)
	    private String correo;

	    @Column(columnDefinition = "TEXT")
	    private String direccion;

	    @Column(nullable = false)
	    private Boolean activo;

}
