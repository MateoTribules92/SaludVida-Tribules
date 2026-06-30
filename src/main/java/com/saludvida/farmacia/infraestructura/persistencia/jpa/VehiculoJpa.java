package com.saludvida.farmacia.infraestructura.persistencia.jpa;

import java.math.BigDecimal;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import com.saludvida.farmacia.dominio.entidades.EstadoVehiculo;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vehiculos", schema = "saludvida")
public class VehiculoJpa {
	
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id_vehiculo")
	    private Integer idVehiculo;

	    @Column(nullable = false, unique = true, length = 20)
	    private String placa;

	    @Column(length = 150)
	    private String descripcion;

	    @Column(name = "capacidad_pedidos", nullable = false)
	    private Integer capacidadPedidos;

	    @Column(name = "capacidad_kg", precision = 10, scale = 2)
	    private BigDecimal capacidadKg;

	    @Enumerated(EnumType.STRING)
	    @JdbcTypeCode(SqlTypes.NAMED_ENUM)
	    @Column(nullable = false,
	            columnDefinition = "saludvida.estado_vehiculo_t")
	    private EstadoVehiculo estado;

	    @Column(nullable = false)
	    private Boolean activo;

}
