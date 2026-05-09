package com.dsi3.Calculadora.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalculadoraRequestDTO {

    private double primerOperando;
    private double segundoOperando;
    private String operacion;
}