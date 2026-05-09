package com.dsi3.Calculadora.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InteresCompuestoRequestDTO {

    private double capitalInicial;
    private double tasaAnual;
    private int    numeroPeriodos;
}