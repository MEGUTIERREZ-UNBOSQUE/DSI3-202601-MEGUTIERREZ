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
    private double tasaAnual;
    private int    numeroPeriodos;
    private String formula;
    private String mensaje;
    private int    status;
    private boolean exitoso;
}