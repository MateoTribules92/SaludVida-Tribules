package com.saludvida.farmacia.infraestructura.persistencia.jpa;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
    name = "ruta_pedidos",
    schema = "saludvida",
    uniqueConstraints = @UniqueConstraint(
        name = "uq_pedido_en_ruta",
        columnNames = "id_pedido"
    )
)
public class RutaPedidoJpa {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ruta_pedido")
    private Integer idRutaPedido;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_ruta", nullable = false)
    private RutaJpa ruta;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_pedido", nullable = false, unique = true)
    private PedidoJpa pedido;

    @Column(name = "orden_entrega", nullable = false)
    private Integer ordenEntrega;

    @Column(name = "fecha_asignacion", nullable = false,
            insertable = false, updatable = false)
    private LocalDateTime fechaAsignacion;
}
