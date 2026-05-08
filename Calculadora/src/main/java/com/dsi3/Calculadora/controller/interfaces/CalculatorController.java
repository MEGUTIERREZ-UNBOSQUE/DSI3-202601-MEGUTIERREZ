package com.dsi3.Calculadora.controller.interfaces;

import com.dsi3.Calculadora.model.dto.CalculadoraRequestDTO;
import com.dsi3.Calculadora.model.dto.CalculadoraResponseDTO;
import org.springframework.http.ResponseEntity;

public interface CalculatorController {
    ResponseEntity<CalculadoraResponseDTO> calcular(CalculadoraRequestDTO request);
    ResponseEntity<CalculadoraResponseDTO> sumar(CalculadoraRequestDTO request);
    ResponseEntity<CalculadoraResponseDTO> restar(CalculadoraRequestDTO request);
    ResponseEntity<CalculadoraResponseDTO> multiplicar(CalculadoraRequestDTO request);
    ResponseEntity<CalculadoraResponseDTO> dividir(CalculadoraRequestDTO request);
    ResponseEntity<CalculadoraResponseDTO> convertirMoneda(CalculadoraRequestDTO request);
}