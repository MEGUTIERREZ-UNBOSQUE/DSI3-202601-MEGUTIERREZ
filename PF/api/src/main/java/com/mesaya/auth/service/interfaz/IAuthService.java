package com.mesaya.auth.service.interfaz;

import com.mesaya.auth.dto.AuthDTO.*;

public interface IAuthService {
    UsuarioResponse registrar(RegistroRequest dto);
    UsuarioResponse login(LoginRequest dto);
}
