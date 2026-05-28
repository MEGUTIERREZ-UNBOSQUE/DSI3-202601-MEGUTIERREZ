package com.mesaya.mesa.controller;

import com.mesaya.mesa.dto.MesaDTO.*;
import com.mesaya.mesa.service.interfaz.IMesaService;
import com.mesaya.model.entity.Mesa.EstadoMesa;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/mesas")
@RequiredArgsConstructor
public class MesaController {

    private final IMesaService mesaService;

    @GetMapping
    public ResponseEntity<List<Response>> listar(
            @RequestParam(required = false) EstadoMesa estado) {
        return ResponseEntity.ok(mesaService.listar(estado));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(mesaService.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<Response> crear(@Valid @RequestBody Request dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mesaService.crear(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response> actualizar(@PathVariable Long id,
                                               @Valid @RequestBody Request dto) {
        return ResponseEntity.ok(mesaService.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        mesaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
