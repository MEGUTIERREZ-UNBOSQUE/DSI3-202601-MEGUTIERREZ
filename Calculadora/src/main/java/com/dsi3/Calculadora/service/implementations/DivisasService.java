package com.dsi3.Calculadora.service.implementations;

import com.dsi3.Calculadora.model.dto.DivisasRequestDTO;
import com.dsi3.Calculadora.model.dto.DivisasResponseDTO;
import com.dsi3.Calculadora.model.dto.InteresCompuestoRequestDTO;
import com.dsi3.Calculadora.model.dto.InteresCompuestoResponseDTO;
import com.dsi3.Calculadora.service.interfaces.IDivisasService;
import org.springframework.stereotype.Service;

@Service
public class DivisasService implements IDivisasService {

    private static final double TASA_EURO = 0.00023;
    private static final double TASA_DOLAR = 0.00025;
    private static final double TASA_LIBRA = 0.00020;
    private static final double TASA_YEN = 0.037;
    private static final double TASA_BITCOIN = 0.0000000095;


    private DivisasResponseDTO respuestaExitosaDivisas(double monto, double resultado, String destino) {
        DivisasResponseDTO response = new DivisasResponseDTO();
        response.setMontoOriginal(monto);
        response.setResultado(resultado);
        response.setMonedaDestino(destino);
        response.setStatus(200);
        response.setExitoso(true);
        return response;
    }

    private DivisasResponseDTO respuestaErrorDivisas(double monto, String mensaje) {
        DivisasResponseDTO response = new DivisasResponseDTO();
        response.setMontoOriginal(monto);
        response.setResultado(0);
        response.setMonedaDestino("N/A");
        response.setStatus(400);
        response.setExitoso(false);
        return response;
    }

    private DivisasResponseDTO convertirConTasa(DivisasRequestDTO request, double tasa, String destino) {
        if (request.getMontoPesos() <= 0) {
            return respuestaErrorDivisas(request.getMontoPesos(), "Error: el monto debe ser mayor a cero");
        }
        double resultado = request.getMontoPesos() * tasa;
        return respuestaExitosaDivisas(request.getMontoPesos(), resultado, destino);
    }

    @Override
    public DivisasResponseDTO convertirAEuro(DivisasRequestDTO request) {
        return convertirConTasa(request, TASA_EURO, "EUR");
    }

    @Override
    public DivisasResponseDTO convertirADolar(DivisasRequestDTO request) {
        return convertirConTasa(request, TASA_DOLAR, "USD");
    }

    @Override
    public DivisasResponseDTO convertirALibra(DivisasRequestDTO request) {
        return convertirConTasa(request, TASA_LIBRA, "GBP");
    }

    @Override
    public DivisasResponseDTO convertirAYen(DivisasRequestDTO request) {
        return convertirConTasa(request, TASA_YEN, "JPY");
    }

    @Override
    public DivisasResponseDTO convertirABitcoin(DivisasRequestDTO request) {
        return convertirConTasa(request, TASA_BITCOIN, "BTC");
    }

    @Override
    public DivisasResponseDTO convertir(DivisasRequestDTO request) {
        if (request.getMonedaDestino() == null || request.getMonedaDestino().isEmpty()) {
            return respuestaErrorDivisas(request.getMontoPesos(), "Error: debe especificar una moneda destino");
        }
        switch (request.getMonedaDestino().toLowerCase()) {
            case "euro": return convertirAEuro(request);
            case "dolar": return convertirADolar(request);
            case "libra": return convertirALibra(request);
            case "yen": return convertirAYen(request);
            case "bitcoin": return convertirABitcoin(request);
            default: return respuestaErrorDivisas(request.getMontoPesos(), 
                "Error: moneda no reconocida: " + request.getMonedaDestino());
        }
    }

    private InteresCompuestoResponseDTO respuestaExitosaInteres(double capitalInicial, double capitalFinal, double interesGenerado) {
        InteresCompuestoResponseDTO response = new InteresCompuestoResponseDTO();
        response.setCapitalInicial(capitalInicial);
        response.setCapitalFinal(capitalFinal);
        response.setInteresGenerado(interesGenerado);
        response.setStatus(200);
        response.setExitoso(true);
        return response;
    }

    private InteresCompuestoResponseDTO respuestaErrorInteres(String mensaje) {
        InteresCompuestoResponseDTO response = new InteresCompuestoResponseDTO();
        response.setCapitalInicial(0);
        response.setCapitalFinal(0);
        response.setInteresGenerado(0);
        response.setStatus(400);
        response.setExitoso(false);
        return response;
    }

    @Override
    public InteresCompuestoResponseDTO calcularInteresCompuesto(InteresCompuestoRequestDTO request) {
        // Validaciones
        if (request.getCapitalInicial() <= 0) {
            return respuestaErrorInteres("Error: el capital inicial debe ser mayor a cero");
        }
        if (request.getTasaAnual() <= 0) {
            return respuestaErrorInteres("Error: la tasa anual debe ser mayor a cero");
        }
        if (request.getNumeroPeriodos() <= 0) {
            return respuestaErrorInteres("Error: el numero de periodos debe ser mayor a cero");
        }

        double capitalInicial = request.getCapitalInicial();
        double tasaAnual = request.getTasaAnual() / 100;  // 9.25 → 0.0925
        int meses = request.getNumeroPeriodos();          // 6 meses
        
        double periodosEnAnios = meses / 12.0;
        
        double capitalFinal = capitalInicial * Math.pow(1 + tasaAnual, periodosEnAnios);
        double interesGenerado = capitalFinal - capitalInicial;

        capitalFinal = Math.round(capitalFinal * 100.0) / 100.0;
        interesGenerado = Math.round(interesGenerado * 100.0) / 100.0;

        return respuestaExitosaInteres(capitalInicial, capitalFinal, interesGenerado);
    }
}