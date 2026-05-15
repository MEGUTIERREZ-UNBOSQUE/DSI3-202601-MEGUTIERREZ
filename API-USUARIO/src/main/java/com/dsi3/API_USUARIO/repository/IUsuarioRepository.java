package com.dsi3.API_USUARIO.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dsi3.API_USUARIO.model.entity.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
    

    
}
