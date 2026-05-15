package com.dsi3.API_USUARIO.controller.interfaces;

import com.dsi3.API_USUARIO.model.dto.UsuarioRequestDTO;
import com.dsi3.API_USUARIO.model.dto.UsuarioResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUsuarioController {
    ResponseEntity<UsuarioResponseDTO> crearUsuario(UsuarioRequestDTO request);
    ResponseEntity<List<UsuarioResponseDTO>> obtenerUsuarios();
}