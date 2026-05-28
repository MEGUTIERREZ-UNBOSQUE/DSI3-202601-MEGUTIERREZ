package com.mesaya.mesa.dto;

import com.mesaya.model.entity.Mesa.EstadoMesa;
import jakarta.validation.constraints.*;
import lombok.*;

public class MesaDTO {

    @Data
    public static class Request {
        @NotNull(message = "El número de mesa es obligatorio")
        @Positive
        private Integer numero;

        @NotNull(message = "La capacidad es obligatoria")
        @Positive
        private Integer capacidad;

        private EstadoMesa estado = EstadoMesa.DISPONIBLE;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Response {
        private Long idMesa;
        private Integer numero;
        private Integer capacidad;
        private EstadoMesa estado;
    }
}
