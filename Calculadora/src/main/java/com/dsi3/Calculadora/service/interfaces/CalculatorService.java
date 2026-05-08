package com.dsi3.Calculadora.service.interfaces;

import com.dsi3.Calculadora.model.dto.CalculadoraRequestDTO;
import com.dsi3.Calculadora.model.dto.CalculadoraResponseDTO;

public interface CalculatorService {
    CalculadoraResponseDTO calcular(CalculadoraRequestDTO request);
    CalculadoraResponseDTO sumar(CalculadoraRequestDTO request);
    CalculadoraResponseDTO restar(CalculadoraRequestDTO request);
    CalculadoraResponseDTO multiplicar(CalculadoraRequestDTO request);
    CalculadoraResponseDTO dividir(CalculadoraRequestDTO request);
    CalculadoraResponseDTO convertirMoneda(CalculadoraRequestDTO request);
}