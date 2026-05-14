package com.dsi3.Calculadora.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DivisasResponseDTO {
    private double montoOriginal;
    private double resultado;
    private String monedaDestino;
    private int status;
    private boolean exitoso;
}