package com.saludvida.farmacia.infraestructura.persistencia.jpa;

import java.math.BigDecimal;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
    name = "detalle_pedido",
    schema = "saludvida",
    uniqueConstraints = @UniqueConstraint(
        name = "uq_detalle_pedido_producto",
        columnNames = {"id_pedido", "id_producto"}
    )
)
public class DetallePedidoJpa {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id_detalle")
	    private Integer idDetalle;

	    @ManyToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "id_pedido", nullable = false)
	    private PedidoJpa pedido;

	    @ManyToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "id_producto", nullable = false)
	    private ProductoJpa producto;

	    @Column(nullable = false)
	    private Integer cantidad;

	    @Column(name = "precio_unitario", nullable = false,
	            precision = 12, scale = 2)
	    private BigDecimal precioUnitario;

	    @Column(precision = 12, scale = 2,
	            insertable = false, updatable = false)
	    private BigDecimal subtotal;
}
