package com.dsi3.Calculadora.service.implementations;

import com.dsi3.Calculadora.model.dto.CalculadoraRequestDTO;
import com.dsi3.Calculadora.model.dto.CalculadoraResponseDTO;
import com.dsi3.Calculadora.service.interfaces.ICalculatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CalculadoraService implements ICalculatorService {

    private CalculadoraResponseDTO respuestaExitosa(double resultado, String operacion) {
        CalculadoraResponseDTO response = new CalculadoraResponseDTO();
        response.setResultado(resultado);
        response.setOperacionRealizada(operacion);
        response.setMensaje("Operacion realizada correctamente");
        response.setStatus(200);
        response.setExitoso(true);
        return response;
    }

    private CalculadoraResponseDTO respuestaError(String mensaje) {
        CalculadoraResponseDTO response = new CalculadoraResponseDTO();
        response.setResultado(0);
        response.setOperacionRealizada("N/A");
        response.setMensaje(mensaje);
        response.setStatus(400);
        response.setExitoso(false);
        return response;
    }

    @Override
    public CalculadoraResponseDTO sumar(CalculadoraRequestDTO request) {
        double resultado = request.getPrimerOperando() + request.getSegundoOperando();
        return respuestaExitosa(
            resultado,
            request.getPrimerOperando() + " + " + request.getSegundoOperando() + " = " + resultado
        );
    }

    @Override
    public CalculadoraResponseDTO restar(CalculadoraRequestDTO request) {
        double resultado = request.getPrimerOperando() - request.getSegundoOperando();
        return respuestaExitosa(
            resultado,
            request.getPrimerOperando() + " - " + request.getSegundoOperando() + " = " + resultado
        );
    }

    @Override
    public CalculadoraResponseDTO multiplicar(CalculadoraRequestDTO request) {
        double resultado = request.getPrimerOperando() * request.getSegundoOperando();
        return respuestaExitosa(
            resultado,
            request.getPrimerOperando() + " * " + request.getSegundoOperando() + " = " + resultado
        );
    }

    @Override
    public CalculadoraResponseDTO dividir(CalculadoraRequestDTO request) {
        return request.getSegundoOperando() == 0
            ? respuestaError("Error: no se puede dividir entre cero")
            : respuestaExitosa(
                request.getPrimerOperando() / request.getSegundoOperando(),
                request.getPrimerOperando() + " / " + request.getSegundoOperando() + " = " + (request.getPrimerOperando() / request.getSegundoOperando())
            );
    }

    @Override
    public CalculadoraResponseDTO calcular(CalculadoraRequestDTO request) {
        if (request.getOperacion() == null || request.getOperacion().isEmpty()) {
            return respuestaError("Error: debe especificar una operacion");
        }
        switch (request.getOperacion().toLowerCase()) {
            case "suma":           return sumar(request);
            case "resta":          return restar(request);
            case "multiplicacion": return multiplicar(request);
            case "division":       return dividir(request);
            default:               return respuestaError("Error: operacion no reconocida: " + request.getOperacion());
        }
    }
}