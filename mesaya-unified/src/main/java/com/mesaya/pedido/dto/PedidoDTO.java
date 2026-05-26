package com.mesaya.pedido.dto;

import com.mesaya.model.entity.Pedido.EstadoPedido;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

public class PedidoDTO {

    // ── Crear pedido ─────────────────────────────────────────────────────────
    @Data
    public static class CrearRequest {
        @NotNull(message = "La mesa es obligatoria")
        private Long idMesa;

        private Long idCliente;   // opcional

        @NotNull(message = "El usuario es obligatorio")
        private Long idUsuario;

        private String observaciones;

        @NotNull @Size(min = 1, message = "Debe incluir al menos un producto")
        private List<ItemRequest> items;

        @Data
        public static class ItemRequest {
            @NotNull private Long idProducto;
            @NotNull @Positive private Integer cantidad;
        }
    }

    // ── Agregar ítem a pedido existente ──────────────────────────────────────
    @Data
    public static class AgregarDetalleRequest {
        @NotNull(message = "El producto es obligatorio")
        private Long idProducto;

        @NotNull @Positive(message = "La cantidad debe ser mayor a 0")
        private Integer cantidad;
    }

    // ── Respuesta ────────────────────────────────────────────────────────────
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Response {
        private Long idPedido;
        private Long idMesa;
        private Integer numeroMesa;
        private Long idCliente;
        private String nombreCliente;
        private Long idUsuario;
        private String nombreUsuario;
        private LocalDateTime fechaCreacion;
        private EstadoPedido estado;
        private String observaciones;
        private Double total;
        private List<DetalleResponse> detalles;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DetalleResponse {
        private Long idDetalle;
        private Long idProducto;
        private String nombreProducto;
        private Integer cantidad;
        private Double precioUnitario;
        private Double subtotal;
    }
}
