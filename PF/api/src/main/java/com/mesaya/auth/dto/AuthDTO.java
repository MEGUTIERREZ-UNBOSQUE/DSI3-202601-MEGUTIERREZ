package com.mesaya.auth.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

public class AuthDTO {

    @Data
    public static class RegistroRequest {
        @NotBlank(message = "El nombre es obligatorio")
        @Size(max = 150)
        private String nombre;

        @NotBlank(message = "El correo es obligatorio")
        @Email(message = "Correo inválido")
        private String email;

        @NotBlank(message = "La contraseña es obligatoria")
        @Size(min = 6, message = "Mínimo 6 caracteres")
        private String password;
    }

    @Data
    public static class LoginRequest {
        @NotBlank(message = "El correo es obligatorio")
        @Email(message = "Correo inválido")
        private String email;

        @NotBlank(message = "La contraseña es obligatoria")
        private String password;
    }

    @Data
    public static class UsuarioResponse {
        private Long id;
        private String nombre;
        private String email;

        public UsuarioResponse(Long id, String nombre, String email) {
            this.id = id;
            this.nombre = nombre;
            this.email = email;
        }
    }
}
