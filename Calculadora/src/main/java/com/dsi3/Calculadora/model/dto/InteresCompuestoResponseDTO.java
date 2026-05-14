package com.dsi3.Calculadora.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InteresCompuestoResponseDTO {
    private double capitalInicial;
    private double capitalFinal;
    private double interesGenerado;
    private int status;
    private boolean exitoso;
}