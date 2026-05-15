package com.dsi3.API_USUARIO.service.interface;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.dsi3.API_USUARIO.model.dto.UsuarioRequestDTO;
import com.dsi3.API_USUARIO.model.dto.UsuarioResponseDTO;

public interface IUsuarioService {

    ResponseEntity<UsuarioResponseDTO> crearUsuario(UsuarioRequestDTO usuarioRequestDTO);

    ResponseEntity<List<UsuarioResponseDTO>> obtenerUsuarios();
}