package com.mesaya.cliente.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDateTime;

public class ClienteDTO {

    @Data
    public static class Request {
        @NotBlank(message = "El nombre es obligatorio")
        @Size(max = 150)
        private String nombre;

        @Size(max = 20)
        private String telefono;

        @NotBlank(message = "El correo es obligatorio")
        @Email(message = "Correo inválido")
        private String email;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Response {
        private Long idCliente;
        private String nombre;
        private String telefono;
        private String email;
        private LocalDateTime fechaRegistro;
    }
}
