package com.dsi3.Calculadora.service.interfaces;

import com.dsi3.Calculadora.model.dto.CientificaRequestDTO;
import com.dsi3.Calculadora.model.dto.CientificaResponseDTO;

public interface ICientificaService {
    CientificaResponseDTO calcularSeno(CientificaRequestDTO request);
    CientificaResponseDTO calcularCoseno(CientificaRequestDTO request);
    CientificaResponseDTO calcularTangente(CientificaRequestDTO request);
    CientificaResponseDTO calcularRaizCuadrada(CientificaRequestDTO request);
    CientificaResponseDTO calcularPotencia(CientificaRequestDTO request);
    CientificaResponseDTO calcularLogaritmo(CientificaRequestDTO request);
    CientificaResponseDTO calcularLogNatural(CientificaRequestDTO request);
    CientificaResponseDTO calcularExponencial(CientificaRequestDTO request);
    CientificaResponseDTO operar(CientificaRequestDTO request);
}