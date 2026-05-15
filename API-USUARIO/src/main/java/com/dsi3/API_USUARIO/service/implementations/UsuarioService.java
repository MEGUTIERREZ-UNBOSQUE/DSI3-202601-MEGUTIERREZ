package com.dsi3.API_USUARIO.service.implementations;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.dsi3.API_USUARIO.model.dto.UsuarioRequestDTO;
import com.dsi3.API_USUARIO.model.dto.UsuarioResponseDTO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UsuarioService implements IUsuarioService {
    private final IUsuarioMApper usuarioMapper;
    private final IUsuarioRepository usuarioRepository;
    @Override
    public ResponseEntity<UsuarioResponseDTO> crearUsuario(
        UsuarioRequestDTO request) {

    usuario usuario = usuarioMapper.toEntity(request);

    usuario newUsuario = usuarioRepository.save(usuario);

    usuarioResponseDTO response = usuarioMapper.toDTO(newUsuario);

    return ResponseEntity.status(201).body(responseUser);}

    @Override
    public ResponseEntity<List<UsuarioResponseDTO>> obtenerUsuarios() {
        List<usuario> usuarios = usuarioRepository.findAll();
        list<usuarioREsponseDTO> responseUsuarios = new ArrayList<>();
        for (int i = 0; i < usuarios.size(); i++) {
        usuariorespnseDTO response = usuarioMapper;
        usuarioToUsuaiorResponse(usuarios.get(i));
        
        }
        return ResponseEntity.ok(responseUsuarios);
    }

