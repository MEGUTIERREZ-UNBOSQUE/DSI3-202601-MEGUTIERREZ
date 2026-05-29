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
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioService implements IUsuarioService {

    private final UsuarioMapper usuarioMapper;
    private final IUsuarioRepository usuarioRepository;

    @Override
    public ResponseEntity<UsuarioResponseDTO> crearUsuario(UsuarioRequestDTO request) {

        Optional<Usuario> usuarioExistente = usuarioRepository.findByEmail(request.getEmail());

        if (usuarioExistente.isPresent()) {
            return ResponseEntity.status(409).body(null);
        }

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

    @Override
    public ResponseEntity<UsuarioResponseDTO> obtenerUsuario(Long id) {

        Optional<Usuario> usuario = usuarioRepository.findById(id);

        return usuario.isPresent()
            ? ResponseEntity.ok(usuarioMapper.toDTO(usuario.get()))
            : ResponseEntity.status(404).body(null);
    }

    @Override
    public ResponseEntity<UsuarioResponseDTO> actualizarUsuario(Long id, UsuarioRequestDTO request) {

        Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);

        if (usuarioExistente.isEmpty()) {
            return ResponseEntity.status(404).body(null);
        }

        Usuario usuario = usuarioExistente.get();
        usuario.setNombre(request.getNombre());
        usuario.setEmail(request.getEmail());
        usuario.setPassword(request.getPassword());
        usuario.setEdad(request.getEdad());

        Usuario usuarioActualizado = usuarioRepository.save(usuario);

        return ResponseEntity.ok(usuarioMapper.toDTO(usuarioActualizado));
    }

    @Override
    public ResponseEntity<Void> eliminarUsuario(Long id) {

        Optional<Usuario> usuario = usuarioRepository.findById(id);

        if (usuario.isEmpty()) {
            return ResponseEntity.status(404).build();
        }

        usuarioRepository.deleteById(id);

        return ResponseEntity.status(204).build();
    }

    @Override
    public ResponseEntity<UsuarioResponseDTO> login(UsuarioRequestDTO request) {

        Optional<Usuario> usuario = usuarioRepository.findByEmail(request.getEmail());

        if (usuario.isEmpty()) {
            return ResponseEntity.status(404).body(null);
        }

        return usuario.get().getPassword().equals(request.getPassword())
            ? ResponseEntity.ok(usuarioMapper.toDTO(usuario.get()))
            : ResponseEntity.status(401).body(null);
    }
}