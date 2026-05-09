package com.dsi3.Calculadora.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalculadoraResponseDTO {

    private double resultado;
    private String operacionRealizada;
    private String mensaje;
    private int status;
    private boolean exitoso;
}