package com.dsi3.API_USUARIO.mapper;

import com.dsi3.API_USUARIO.model.dto.UsuarioRequestDTO;
import com.dsi3.API_USUARIO.model.dto.UsuarioResponseDTO;
import com.dsi3.API_USUARIO.model.entity.Usuario;

public class UsuarioMapper {
    
    public Usuario usuariorequestTOUsuario(UsuarioRequestDTO dto){
        return Usuario.builder()
        .nombre(dto.getNombre())
        .email(dto.getEmail())
        .password(dto.getPassword())
        .build();
    }
    public UsuarioResponseDTO UsuarioTOUsuarioResponseDTO(Usuario model){
        return UsuarioResponseDTO.builder()
        .id(model.getId())
        .nombre(model.getNombre())
        .build();
    }
}
