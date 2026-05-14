package com.dsi3.Calculadora.service.implementations;

import com.dsi3.Calculadora.model.dto.CientificaRequestDTO;
import com.dsi3.Calculadora.model.dto.CientificaResponseDTO;
import com.dsi3.Calculadora.service.interfaces.ICientificaService;
import org.springframework.stereotype.Service;

@Service
public class CientificaService implements ICientificaService {

    private CientificaResponseDTO respuestaExitosa(double entrada, double resultado) {
        CientificaResponseDTO response = new CientificaResponseDTO();
        response.setValorEntrada(entrada);
        response.setResultado(resultado);
        response.setStatus(200);
        response.setExitoso(true);
        return response;
    }

    private CientificaResponseDTO respuestaError(String mensaje) {
        CientificaResponseDTO response = new CientificaResponseDTO();
        response.setValorEntrada(0);
        response.setResultado(0);
        response.setStatus(400);
        response.setExitoso(false);
        return response;
    }

    @Override
    public CientificaResponseDTO calcularSeno(CientificaRequestDTO request) {
        double radianes = Math.toRadians(request.getValor());
        double resultado = Math.sin(radianes);
        return respuestaExitosa(request.getValor(), resultado);
    }

    @Override
    public CientificaResponseDTO calcularCoseno(CientificaRequestDTO request) {
        double radianes = Math.toRadians(request.getValor());
        double resultado = Math.cos(radianes);
        return respuestaExitosa(request.getValor(), resultado);
    }

    @Override
    public CientificaResponseDTO calcularTangente(CientificaRequestDTO request) {
        double radianes = Math.toRadians(request.getValor());
        double resultado = Math.tan(radianes);
        return respuestaExitosa(request.getValor(), resultado);
    }

    @Override
    public CientificaResponseDTO calcularRaizCuadrada(CientificaRequestDTO request) {
        if (request.getValor() < 0) {
            return respuestaError("Error: no se puede calcular raiz cuadrada de numero negativo");
        }
        double resultado = Math.sqrt(request.getValor());
        return respuestaExitosa(request.getValor(), resultado);
    }

    @Override
    public CientificaResponseDTO calcularPotencia(CientificaRequestDTO request) {
        double resultado = Math.pow(request.getValor(), request.getExponente());
        return respuestaExitosa(request.getValor(), resultado);
    }

    @Override
    public CientificaResponseDTO calcularLogaritmo(CientificaRequestDTO request) {
        if (request.getValor() <= 0) {
            return respuestaError("Error: el logaritmo solo esta definido para numeros positivos");
        }
        double resultado = Math.log10(request.getValor());
        return respuestaExitosa(request.getValor(), resultado);
    }

    @Override
    public CientificaResponseDTO calcularLogNatural(CientificaRequestDTO request) {
        if (request.getValor() <= 0) {
            return respuestaError("Error: el logaritmo natural solo esta definido para numeros positivos");
        }
        double resultado = Math.log(request.getValor());
        return respuestaExitosa(request.getValor(), resultado);
    }

    @Override
    public CientificaResponseDTO calcularExponencial(CientificaRequestDTO request) {
        double resultado = Math.exp(request.getValor());
        return respuestaExitosa(request.getValor(), resultado);
    }

    @Override
    public CientificaResponseDTO operar(CientificaRequestDTO request) {
        if (request.getOperacion() == null || request.getOperacion().isEmpty()) {
            return respuestaError("Error: debe especificar una operacion");
        }
        switch (request.getOperacion().toLowerCase()) {
            case "seno": return calcularSeno(request);
            case "coseno": return calcularCoseno(request);
            case "tangente": return calcularTangente(request);
            case "raiz": return calcularRaizCuadrada(request);
            case "potencia": return calcularPotencia(request);
            case "log": return calcularLogaritmo(request);
            case "ln": return calcularLogNatural(request);
            case "exp": return calcularExponencial(request);
            default: return respuestaError("Error: operacion no reconocida: " + request.getOperacion());
        }
    }
}