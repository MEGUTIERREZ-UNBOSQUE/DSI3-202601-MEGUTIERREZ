package com.dsi3.Calculadora.controller.interfaces;

import com.dsi3.Calculadora.model.dto.InteresCompuestoRequestDTO;
import com.dsi3.Calculadora.model.dto.InteresCompuestoResponseDTO;
import org.springframework.http.ResponseEntity;

public interface IFinancieraController {

    ResponseEntity<InteresCompuestoResponseDTO> calcularInteresCompuesto(InteresCompuestoRequestDTO request);
}