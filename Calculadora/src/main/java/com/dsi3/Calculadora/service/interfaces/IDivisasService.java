package com.dsi3.Calculadora.service.interfaces;

import com.dsi3.Calculadora.model.dto.DivisasRequestDTO;
import com.dsi3.Calculadora.model.dto.DivisasResponseDTO;
import com.dsi3.Calculadora.model.dto.InteresCompuestoRequestDTO;
import com.dsi3.Calculadora.model.dto.InteresCompuestoResponseDTO;

public interface IDivisasService {

    DivisasResponseDTO convertir(DivisasRequestDTO request);

    DivisasResponseDTO convertirAEuro(DivisasRequestDTO request);

    DivisasResponseDTO convertirADolar(DivisasRequestDTO request);

    DivisasResponseDTO convertirALibra(DivisasRequestDTO request);

    DivisasResponseDTO convertirAYen(DivisasRequestDTO request);

    DivisasResponseDTO convertirABitcoin(DivisasRequestDTO request);

    InteresCompuestoResponseDTO calcularInteresCompuesto(InteresCompuestoRequestDTO request);
}