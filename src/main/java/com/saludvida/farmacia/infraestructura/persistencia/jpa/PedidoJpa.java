package com.saludvida.farmacia.infraestructura.persistencia.jpa;

import java.math.BigDecimal;
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
@Table(name = "pedidos", schema = "saludvida")
public class PedidoJpa {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Integer idPedido;

    @Column(name = "numero_pedido", nullable = false,
            unique = true, length = 30)
    private String numeroPedido;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_cliente", nullable = false)
    private ClienteJpa cliente;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_farmacia", nullable = false)
    private FarmaciaJpa farmacia;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_vendedor", nullable = false)
    private UsuarioJpa vendedor;

    @Enumerated(EnumType.STRING)
    @JdbcTypeCode(SqlTypes.NAMED_ENUM)
    @Column(nullable = false,
            columnDefinition = "saludvida.estado_pedido_t")
    private EstadoPedido estado;

    @Column(nullable = false, precision = 12, scale = 2,
            insertable = false, updatable = false)
    private BigDecimal total;

    @Column(name = "direccion_entrega", columnDefinition = "TEXT")
    private String direccionEntrega;

    @Column(columnDefinition = "TEXT")
    private String observacion;

    @Column(name = "fecha_pedido", nullable = false,
            insertable = false, updatable = false)
    private LocalDateTime fechaPedido;

    @Column(name = "fecha_actualizacion", nullable = false,
            insertable = false, updatable = false)
    private LocalDateTime fechaActualizacion;

}
