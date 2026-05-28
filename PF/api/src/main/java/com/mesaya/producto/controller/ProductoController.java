package com.mesaya.producto.controller;

import com.mesaya.producto.dto.ProductoDTO.*;
import com.mesaya.producto.service.interfaz.IProductoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/productos")
@RequiredArgsConstructor
public class ProductoController {

    private final IProductoService productoService;

    @GetMapping
    public ResponseEntity<List<Response>> listar(
            @RequestParam(required = false) String categoria,
            @RequestParam(required = false) Boolean disponible) {
        return ResponseEntity.ok(productoService.listar(categoria, disponible));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(productoService.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<Response> crear(@Valid @RequestBody Request dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productoService.crear(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response> actualizar(@PathVariable Long id,
                                               @Valid @RequestBody Request dto) {
        return ResponseEntity.ok(productoService.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        productoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
