import org.springframework.data.convert.ReadingConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.service.annotation.GetExchange;

import jakarta.annotation.PostConstruct;

package com.dsi3.API_USUARIO.controller.interface;

@RequestMapping("api/usuarios")
public interface IUsuarioController {
    
    @PostMapping()
    responseEntity<UsuarioResponseDTO> crearUsuario(@RequestBody UsuarioRequestDTO request);

    @GetMapping()
    responseEntity<list<UsuarioResponseDTO> obtenerUsuario();
}
