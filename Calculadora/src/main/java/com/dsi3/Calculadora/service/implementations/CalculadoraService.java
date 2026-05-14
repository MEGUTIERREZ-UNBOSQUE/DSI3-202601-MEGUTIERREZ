package com.dsi3.Calculadora.service.implementations;

import com.dsi3.Calculadora.model.dto.CalculadoraRequestDTO;
import com.dsi3.Calculadora.model.dto.CalculadoraResponseDTO;
import com.dsi3.Calculadora.service.interfaces.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculadoraService implements ICalculatorService {

    private CalculadoraResponseDTO respuestaExitosa(double resultado) {
        CalculadoraResponseDTO response = new CalculadoraResponseDTO();
        response.setResultado(resultado);
        response.setStatus(200);
        response.setExitoso(true);
        return response;
    }

    private CalculadoraResponseDTO respuestaError(String mensaje) {
        CalculadoraResponseDTO response = new CalculadoraResponseDTO();
        response.setResultado(0);
        response.setStatus(400);
        response.setExitoso(false);
        return response;
    }

    @Override
    public CalculadoraResponseDTO sumar(CalculadoraRequestDTO request) {
        double resultado = request.getPrimerOperando() + request.getSegundoOperando();
        return respuestaExitosa(resultado);
    }

    @Override
    public CalculadoraResponseDTO restar(CalculadoraRequestDTO request) {
        double resultado = request.getPrimerOperando() - request.getSegundoOperando();
        return respuestaExitosa(resultado);
    }

    @Override
    public CalculadoraResponseDTO multiplicar(CalculadoraRequestDTO request) {
        double resultado = request.getPrimerOperando() * request.getSegundoOperando();
        return respuestaExitosa(resultado);
    }

    @Override
    public CalculadoraResponseDTO dividir(CalculadoraRequestDTO request) {
        if (request.getSegundoOperando() == 0) {
            return respuestaError("Error: no se puede dividir entre cero");
        }
        double resultado = request.getPrimerOperando() / request.getSegundoOperando();
        return respuestaExitosa(resultado);
    }

    @Override
    public CalculadoraResponseDTO calcular(CalculadoraRequestDTO request) {
        if (request.getOperacion() == null || request.getOperacion().isEmpty()) {
            return respuestaError("Error: debe especificar una operacion");
        }
        switch (request.getOperacion().toLowerCase()) {
            case "suma": return sumar(request);
            case "resta": return restar(request);
            case "multiplicacion": return multiplicar(request);
            case "division": return dividir(request);
            default: return respuestaError("Error: operacion no reconocida: " + request.getOperacion());
        }
    }
}