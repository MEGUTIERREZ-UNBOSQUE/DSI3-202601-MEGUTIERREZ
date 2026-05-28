package com.mesaya.pedido.controller;

import com.mesaya.model.entity.Pedido.EstadoPedido;
import com.mesaya.pedido.dto.PedidoDTO.*;
import com.mesaya.pedido.service.interfaz.IPedidoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final IPedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<Response>> listar(
            @RequestParam(required = false) EstadoPedido estado) {
        return ResponseEntity.ok(pedidoService.listar(estado));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(pedidoService.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<Response> crear(@Valid @RequestBody CrearRequest dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoService.crear(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        pedidoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    // PATCH → avanza al siguiente estado en el flujo
    @PatchMapping("/{id}/estado")
    public ResponseEntity<Response> avanzarEstado(@PathVariable Long id) {
        return ResponseEntity.ok(pedidoService.avanzarEstado(id));
    }

    @PostMapping("/{id}/detalles")
    public ResponseEntity<Response> agregarDetalle(
            @PathVariable Long id,
            @Valid @RequestBody AgregarDetalleRequest dto) {
        return ResponseEntity.ok(pedidoService.agregarDetalle(id, dto));
    }

    @DeleteMapping("/{id}/detalles/{detalleId}")
    public ResponseEntity<Response> eliminarDetalle(
            @PathVariable Long id,
            @PathVariable Long detalleId) {
        return ResponseEntity.ok(pedidoService.eliminarDetalle(id, detalleId));
    }
}
