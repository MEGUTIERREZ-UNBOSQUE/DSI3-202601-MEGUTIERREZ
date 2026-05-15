package com.dsi3.API_USUARIO.service.implementations;

import com.dsi3.API_USUARIO.mapper.UsuarioMapper;
import com.dsi3.API_USUARIO.model.dto.UsuarioRequestDTO;
import com.dsi3.API_USUARIO.model.dto.UsuarioResponseDTO;
import com.dsi3.API_USUARIO.model.entity.Usuario;
import com.dsi3.API_USUARIO.repository.IUsuarioRepository;
import com.dsi3.API_USUARIO.service.interfaces.IUsuarioService;

import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UsuarioService implements IUsuarioService {

    private final UsuarioMapper usuarioMapper;
    private final IUsuarioRepository usuarioRepository;

    @Override
    public ResponseEntity<UsuarioResponseDTO> crearUsuario(UsuarioRequestDTO request) {

        Usuario usuario = usuarioMapper.toEntity(request);

        Usuario newUsuario = usuarioRepository.save(usuario);

        UsuarioResponseDTO response = usuarioMapper.toDTO(newUsuario);

        return ResponseEntity.status(201).body(response);
    }

    @Override
    public ResponseEntity<List<UsuarioResponseDTO>> obtenerUsuarios() {

        List<Usuario> usuarios = usuarioRepository.findAll();

        List<UsuarioResponseDTO> responseUsuarios = new ArrayList<>();

        for (int i = 0; i < usuarios.size(); i++) {
            UsuarioResponseDTO response = usuarioMapper.toDTO(usuarios.get(i));
            responseUsuarios.add(response);
        }

        return ResponseEntity.ok(responseUsuarios);
    }
}