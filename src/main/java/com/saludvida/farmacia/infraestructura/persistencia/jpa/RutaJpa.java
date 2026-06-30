package com.saludvida.farmacia.infraestructura.persistencia.jpa;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import com.saludvida.farmacia.dominio.entidades.EstadoRuta;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rutas", schema = "saludvida")
public class RutaJpa {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id_ruta")
	    private Integer idRuta;

	    @Column(name = "codigo_ruta", nullable = false,
	            unique = true, length = 30)
	    private String codigoRuta;

	    @Column(name = "fecha_ruta", nullable = false)
	    private LocalDate fechaRuta;

	    @Column(nullable = false, length = 80)
	    private String zona;

	    @ManyToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "id_vehiculo", nullable = false)
	    private VehiculoJpa vehiculo;

	    @ManyToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "id_distribuidor", nullable = false)
	    private UsuarioJpa distribuidor;

	    @Enumerated(EnumType.STRING)
	    @JdbcTypeCode(SqlTypes.NAMED_ENUM)
	    @Column(nullable = false,
	            columnDefinition = "saludvida.estado_ruta_t")
	    private EstadoRuta estado;

	    @Column(columnDefinition = "TEXT")
	    private String observacion;

	    @Column(name = "fecha_creacion", nullable = false,
	            insertable = false, updatable = false)
	    private LocalDateTime fechaCreacion;

	    @Column(name = "fecha_actualizacion", nullable = false,
	            insertable = false, updatable = false)
	    private LocalDateTime fechaActualizacion;
}
