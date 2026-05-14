package com.dsi3.Calculadora.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CientificaRequestDTO {
    private double valor;
    private String operacion;  // seno, coseno, tangente, raiz, potencia, log, ln, exp
    private double exponente;   // solo para potencia
}