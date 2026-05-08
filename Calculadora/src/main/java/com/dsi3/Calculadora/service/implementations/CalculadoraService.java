package com.dsi3.Calculadora.service.implementations;

import com.dsi3.Calculadora.model.dto.CalculadoraRequestDTO;
import com.dsi3.Calculadora.model.dto.CalculadoraResponseDTO;
import com.dsi3.Calculadora.service.interfaces.CalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculadoraService implements CalculatorService {

    private static final double TASA_EURO = 0.00023;
    private static final double TASA_DOLAR = 0.00025;
    private static final double TASA_LIBRA = 0.00020;
    private static final double TASA_YEN = 0.037;
    private static final double TASA_BITCOIN = 0.0000000095;

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
    public CalculadoraResponseDTO convertirMoneda(CalculadoraRequestDTO request) {
        double monto = request.getMontoPesos();
        String destino = request.getMonedaDestino().toLowerCase();
        double tasa;
        String nombreMoneda;

        switch (destino) {
            case "euro":
                tasa = TASA_EURO;
                nombreMoneda = "EUR";
                break;
            case "dolar":
                tasa = TASA_DOLAR;
                nombreMoneda = "USD";
                break;
            case "libra":
                tasa = TASA_LIBRA;
                nombreMoneda = "GBP";
                break;
            case "yen":
                tasa = TASA_YEN;
                nombreMoneda = "JPY";
                break;
            case "bitcoin":
                tasa = TASA_BITCOIN;
                nombreMoneda = "BTC";
                break;
            default:
                return new CalculadoraResponseDTO(
                    0,
                    "Moneda no reconocida: " + request.getMonedaDestino(),
                    "N/A",
                    false
                );
        }

        double resultado = monto * tasa;
        return new CalculadoraResponseDTO(
            monto,
            "Conversion realizada correctamente",
            monto + " COP = " + resultado + " " + nombreMoneda,
            true,
            resultado,
            nombreMoneda
        );
    }

    @Override
    public CalculadoraResponseDTO calcular(CalculadoraRequestDTO request) {
        switch (request.getOperacion().toLowerCase()) {
            case "suma": return sumar(request);
            case "resta": return restar(request);
            case "multiplicacion": return multiplicar(request);
            case "division": return dividir(request);
            case "conversion": return convertirMoneda(request);
            default: return new CalculadoraResponseDTO(
                0,
                "Operacion no reconocida: " + request.getOperacion(),
                "N/A",
                false
            );
        }
    }
}