package com.dsi3.Calculadora.controller.interfaces;

import com.dsi3.Calculadora.model.dto.CientificaRequestDTO;
import com.dsi3.Calculadora.model.dto.CientificaResponseDTO;
import org.springframework.http.ResponseEntity;

public interface ICientificaController {
    ResponseEntity<CientificaResponseDTO> seno(CientificaRequestDTO request);
    ResponseEntity<CientificaResponseDTO> coseno(CientificaRequestDTO request);
    ResponseEntity<CientificaResponseDTO> tangente(CientificaRequestDTO request);
    ResponseEntity<CientificaResponseDTO> raizCuadrada(CientificaRequestDTO request);
    ResponseEntity<CientificaResponseDTO> potencia(CientificaRequestDTO request);
    ResponseEntity<CientificaResponseDTO> logaritmo(CientificaRequestDTO request);
    ResponseEntity<CientificaResponseDTO> logNatural(CientificaRequestDTO request);
    ResponseEntity<CientificaResponseDTO> exponencial(CientificaRequestDTO request);
    ResponseEntity<CientificaResponseDTO> operar(CientificaRequestDTO request);
}