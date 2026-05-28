package com.mesaya.cliente.controller;

import com.mesaya.cliente.dto.ClienteDTO.*;
import com.mesaya.cliente.service.interfaz.IClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final IClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Response>> listar(
            @RequestParam(required = false) String busqueda) {
        return ResponseEntity.ok(clienteService.listar(busqueda));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<Response> crear(@Valid @RequestBody Request dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.crear(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response> actualizar(@PathVariable Long id,
                                               @Valid @RequestBody Request dto) {
        return ResponseEntity.ok(clienteService.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        clienteService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
