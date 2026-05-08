package com.dsi3.Calculadora.service.implementations;

import com.dsi3.Calculadora.model.dto.CalculadoraRequestDTO;
import com.dsi3.Calculadora.model.dto.CalculadoraResponseDTO;
import com.dsi3.Calculadora.service.interfaces.CalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculadoraService implements CalculatorService {

    @Override
    public CalculadoraResponseDTO sumar(CalculadoraRequestDTO request) {
        double resultado = request.getPrimerOperando() + request.getSegundoOperando();
        return new CalculadoraResponseDTO(
            resultado,
            "Suma realizada correctamente",
            request.getPrimerOperando() + " + " + request.getSegundoOperando() + " = " + resultado,
            true
        );
    }

    @Override
    public CalculadoraResponseDTO restar(CalculadoraRequestDTO request) {
        double resultado = request.getPrimerOperando() - request.getSegundoOperando();
        return new CalculadoraResponseDTO(
            resultado,
            "Resta realizada correctamente",
            request.getPrimerOperando() + " - " + request.getSegundoOperando() + " = " + resultado,
            true
        );
    }

    @Override
    public CalculadoraResponseDTO multiplicar(CalculadoraRequestDTO request) {
        double resultado = request.getPrimerOperando() * request.getSegundoOperando();
        return new CalculadoraResponseDTO(
            resultado,
            "Multiplicacion realizada correctamente",
            request.getPrimerOperando() + " * " + request.getSegundoOperando() + " = " + resultado,
            true
        );
    }

    @Override
    public CalculadoraResponseDTO dividir(CalculadoraRequestDTO request) {
        return request.getSegundoOperando() == 0
            ? new CalculadoraResponseDTO(
                0,
                "Error: division entre cero no permitida",
                request.getPrimerOperando() + " / " + request.getSegundoOperando(),
                false
            )
            : new CalculadoraResponseDTO(
                request.getPrimerOperando() / request.getSegundoOperando(),
                "Division realizada correctamente",
                request.getPrimerOperando() + " / " + request.getSegundoOperando() + " = " + (request.getPrimerOperando() / request.getSegundoOperando()),
                true
            );
    }

    @Override
    public CalculadoraResponseDTO calcular(CalculadoraRequestDTO request) {
        switch (request.getOperacion().toLowerCase()) {
            case "suma": return sumar(request);
            case "resta": return restar(request);
            case "multiplicacion": return multiplicar(request);
            case "division": return dividir(request);
            default: return new CalculadoraResponseDTO(
                0,
                "Operacion no reconocida: " + request.getOperacion(),
                "N/A",
                false
            );
        }
    }
}