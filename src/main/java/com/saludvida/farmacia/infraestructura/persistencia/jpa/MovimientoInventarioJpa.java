package com.saludvida.farmacia.infraestructura.persistencia.jpa;

import java.time.LocalDateTime;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import com.saludvida.farmacia.dominio.entidades.TipoMovimiento;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "movimientos_inventario", schema = "saludvida")
public class MovimientoInventarioJpa {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id_movimiento")
	    private Integer idMovimiento;

	    @ManyToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "id_inventario", nullable = false)
	    private InventarioJpa inventario;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "id_usuario")
	    private UsuarioJpa usuario;

	    @Enumerated(EnumType.STRING)
	    @JdbcTypeCode(SqlTypes.NAMED_ENUM)
	    @Column(name = "tipo_movimiento",
	            nullable = false,
	            columnDefinition = "saludvida.tipo_movimiento_t")
	    private TipoMovimiento tipoMovimiento;

	    @Column(nullable = false)
	    private Integer cantidad;

	    @Column(columnDefinition = "TEXT")
	    private String motivo;

	    @Column(name = "fecha_movimiento", nullable = false,
	            insertable = false, updatable = false)
	    private LocalDateTime fechaMovimiento;

}
