package com.mesaya.auth.service.impl;

import com.mesaya.auth.dto.AuthDTO.*;
import com.mesaya.auth.service.interfaz.IAuthService;
import com.mesaya.exception.*;
import com.mesaya.model.entity.Usuario;
import com.mesaya.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements IAuthService {

    private final UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public UsuarioResponse registrar(RegistroRequest dto) {
        if (usuarioRepository.existsByEmail(dto.getEmail())) {
            throw new BusinessException("El correo ya está registrado.");
        }
        Usuario u = new Usuario();
        u.setNombre(dto.getNombre());
        u.setEmail(dto.getEmail());
        u.setPasswordHash(passwordEncoder.encode(dto.getPassword()));
        u.setActivo(true);
        Usuario saved = usuarioRepository.save(u);
        return new UsuarioResponse(saved.getIdUsuario(), saved.getNombre(), saved.getEmail());
    }

    @Override
    @Transactional(readOnly = true)
    public UsuarioResponse login(LoginRequest dto) {
        Usuario u = usuarioRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado."));
        if (!passwordEncoder.matches(dto.getPassword(), u.getPasswordHash())) {
            throw new BusinessException("Contraseña incorrecta.");
        }
        return new UsuarioResponse(u.getIdUsuario(), u.getNombre(), u.getEmail());
    }
}
