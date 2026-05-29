package com.dsi3.API_USUARIO.controller.interfaces;

import com.dsi3.API_USUARIO.model.dto.UsuarioRequestDTO;
import com.dsi3.API_USUARIO.model.dto.UsuarioResponseDTO;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/api/usuarios")
public interface IUsuarioController {

    @PostMapping
    ResponseEntity<UsuarioResponseDTO> crearUsuario(@RequestBody UsuarioRequestDTO request);

    @GetMapping
    ResponseEntity<List<UsuarioResponseDTO>> obtenerUsuarios();

    @GetMapping("/{id}")
    ResponseEntity<UsuarioResponseDTO> obtenerUsuario(@PathVariable Long id);

    @PutMapping("/{id}")
    ResponseEntity<UsuarioResponseDTO> actualizarUsuario(@PathVariable Long id, @RequestBody UsuarioRequestDTO request);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> eliminarUsuario(@PathVariable Long id);

    @PostMapping("/sesion")
    ResponseEntity<UsuarioResponseDTO> login(@RequestBody UsuarioRequestDTO request);
}