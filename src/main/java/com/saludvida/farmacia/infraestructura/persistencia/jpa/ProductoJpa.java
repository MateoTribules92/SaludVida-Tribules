package com.saludvida.farmacia.infraestructura.persistencia.jpa;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "productos", schema = "saludvida")
public class ProductoJpa {

	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id_producto")
	    private Integer idProducto;

	    @Column(nullable = false, unique = true, length = 50)
	    private String codigo;

	    @Column(nullable = false, length = 150)
	    private String nombre;

	    @Column(columnDefinition = "TEXT")
	    private String descripcion;

	    @ManyToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "id_categoria", nullable = false)
	    private CategoriaJpa categoria;

	    @ManyToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "id_proveedor", nullable = false)
	    private ProveedorJpa proveedor;

	    @Column(nullable = false, precision = 12, scale = 2)
	    private BigDecimal precio;

	    @Column(name = "fecha_caducidad", nullable = false)
	    private LocalDate fechaCaducidad;

	    @Column(nullable = false)
	    private Boolean activo;

	    @Column(name = "fecha_creacion", nullable = false,
	            insertable = false, updatable = false)
	    private LocalDateTime fechaCreacion;

	    @Column(name = "fecha_actualizacion", nullable = false,
	            insertable = false, updatable = false)
	    private LocalDateTime fechaActualizacion;
}
