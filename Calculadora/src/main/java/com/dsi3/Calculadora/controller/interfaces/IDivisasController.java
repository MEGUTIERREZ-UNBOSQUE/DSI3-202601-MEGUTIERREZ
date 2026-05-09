package com.dsi3.Calculadora.controller.interfaces;

import com.dsi3.Calculadora.model.dto.DivisasRequestDTO;
import com.dsi3.Calculadora.model.dto.DivisasResponseDTO;
import org.springframework.http.ResponseEntity;

public interface IDivisasController {

    ResponseEntity<DivisasResponseDTO> convertir(DivisasRequestDTO request);

    ResponseEntity<DivisasResponseDTO> convertirAEuro(DivisasRequestDTO request);

    ResponseEntity<DivisasResponseDTO> convertirADolar(DivisasRequestDTO request);

    ResponseEntity<DivisasResponseDTO> convertirALibra(DivisasRequestDTO request);

    ResponseEntity<DivisasResponseDTO> convertirAYen(DivisasRequestDTO request);

    ResponseEntity<DivisasResponseDTO> convertirABitcoin(DivisasRequestDTO request);
}