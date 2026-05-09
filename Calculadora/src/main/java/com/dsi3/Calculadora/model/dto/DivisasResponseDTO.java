package com.dsi3.Calculadora.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DivisasResponseDTO {

    private double montoOriginal;
    private double conversionValue;
    private double conversionRate;
    private String monedaOrigen;
    private String monedaDestino;
    private String mensaje;
    private int status;
    private boolean exitoso;
}