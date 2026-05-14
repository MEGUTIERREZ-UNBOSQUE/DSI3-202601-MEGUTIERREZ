package com.dsi3.Calculadora.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CientificaResponseDTO {
    private double valorEntrada;
    private double resultado;
    private int status;
    private boolean exitoso;
}