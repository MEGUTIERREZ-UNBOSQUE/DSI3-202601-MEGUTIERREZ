package com.mesaya.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedido")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Long idPedido;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_mesa", nullable = false)
    private Mesa mesa;

    // Cliente es opcional — pedido sin cliente registrado
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "id_cliente", nullable = true)
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @CreationTimestamp
    @Column(name = "fecha_creacion", nullable = false, updatable = false)
    private LocalDateTime fechaCreacion;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false, length = 20)
    private EstadoPedido estado = EstadoPedido.CREADA;

    @Column(name = "observaciones", columnDefinition = "TEXT")
    private String observaciones;

    @OneToMany(
        mappedBy = "pedido",
        cascade = CascadeType.ALL,
        orphanRemoval = true,
        fetch = FetchType.LAZY
    )
    private List<DetallePedido> detalles = new ArrayList<>();

    // ── Máquina de estados ───────────────────────────────────────────────────
    public enum EstadoPedido {
        CREADA, EN_PREPARACION, ENTREGADA;

        /** Avanza al siguiente estado. Lanza excepción si ya está ENTREGADA. */
        public EstadoPedido siguiente() {
            return switch (this) {
                case CREADA         -> EN_PREPARACION;
                case EN_PREPARACION -> ENTREGADA;
                case ENTREGADA      ->
                    throw new IllegalStateException("El pedido ya fue entregado y no puede avanzar.");
            };
        }
    }
}
