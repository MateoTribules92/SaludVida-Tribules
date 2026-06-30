package com.saludvida.farmacia.infraestructura.persistencia.jpa;

import java.time.LocalDateTime;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import com.saludvida.farmacia.dominio.entidades.EstadoPedido;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "historial_estado_pedido", schema = "saludvida")
public class HistorialEstadoPedidoJpa {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_historial")
    private Integer idHistorial;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_pedido", nullable = false)
    private PedidoJpa pedido;

    @Enumerated(EnumType.STRING)
    @JdbcTypeCode(SqlTypes.NAMED_ENUM)
    @Column(name = "estado_anterior",
            columnDefinition = "saludvida.estado_pedido_t")
    private EstadoPedido estadoAnterior;

    @Enumerated(EnumType.STRING)
    @JdbcTypeCode(SqlTypes.NAMED_ENUM)
    @Column(name = "estado_nuevo", nullable = false,
            columnDefinition = "saludvida.estado_pedido_t")
    private EstadoPedido estadoNuevo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private UsuarioJpa usuario;

    @Column(columnDefinition = "TEXT")
    private String observacion;

    @Column(name = "fecha_registro", nullable = false,
            insertable = false, updatable = false)
    private LocalDateTime fechaRegistro;

}
