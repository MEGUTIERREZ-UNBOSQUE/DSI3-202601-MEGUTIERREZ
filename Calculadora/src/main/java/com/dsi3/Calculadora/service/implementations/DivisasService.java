package com.dsi3.Calculadora.service.implementations;

import com.dsi3.Calculadora.model.dto.DivisasRequestDTO;
import com.dsi3.Calculadora.model.dto.DivisasResponseDTO;
import com.dsi3.Calculadora.model.dto.InteresCompuestoRequestDTO;
import com.dsi3.Calculadora.model.dto.InteresCompuestoResponseDTO;
import com.dsi3.Calculadora.service.interfaces.IDivisasService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class DivisasService implements IDivisasService {

    private static final double TASA_EURO    = 0.00023;
    private static final double TASA_DOLAR   = 0.00025;
    private static final double TASA_LIBRA   = 0.00020;
    private static final double TASA_YEN     = 0.037;
    private static final double TASA_BITCOIN = 0.0000000095;

    private DivisasResponseDTO respuestaExitosa(double monto, double tasa, String destino) {
        DivisasResponseDTO response = new DivisasResponseDTO();
        response.setMontoOriginal(monto);
        response.setConversionRate(tasa);
        response.setConversionValue(monto * tasa);
        response.setMonedaOrigen("COP");
        response.setMonedaDestino(destino);
        response.setMensaje("Conversion realizada correctamente");
        response.setStatus(200);
        response.setExitoso(true);
        return response;
    }

    private DivisasResponseDTO respuestaError(double monto, String mensaje) {
        DivisasResponseDTO response = new DivisasResponseDTO();
        response.setMontoOriginal(monto);
        response.setConversionRate(0);
        response.setConversionValue(0);
        response.setMonedaOrigen("COP");
        response.setMonedaDestino("N/A");
        response.setMensaje(mensaje);
        response.setStatus(400);
        response.setExitoso(false);
        return response;
    }

    private DivisasResponseDTO convertirConTasa(DivisasRequestDTO request, double tasa, String destino) {
        return request.getMontoPesos() <= 0
            ? respuestaError(request.getMontoPesos(), "Error: el monto debe ser mayor a cero")
            : respuestaExitosa(request.getMontoPesos(), tasa, destino);
    }

    private InteresCompuestoResponseDTO respuestaErrorInteres(String mensaje) {
        InteresCompuestoResponseDTO response = new InteresCompuestoResponseDTO();
        response.setCapitalInicial(0);
        response.setCapitalFinal(0);
        response.setInteresGenerado(0);
        response.setTasaAnual(0);
        response.setNumeroPeriodos(0);
        response.setFormula("N/A");
        response.setMensaje(mensaje);
        response.setStatus(400);
        response.setExitoso(false);
        return response;
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
            return respuestaError(request.getMontoPesos(), "Error: debe especificar una moneda destino");
        }
        switch (request.getMonedaDestino().toLowerCase()) {
            case "euro":    return convertirAEuro(request);
            case "dolar":   return convertirADolar(request);
            case "libra":   return convertirALibra(request);
            case "yen":     return convertirAYen(request);
            case "bitcoin": return convertirABitcoin(request);
            default:        return respuestaError(
                                request.getMontoPesos(),
                                "Error: moneda no reconocida: " + request.getMonedaDestino()
                            );
        }
    }

    @Override
public InteresCompuestoResponseDTO calcularInteresCompuesto(InteresCompuestoRequestDTO request) {

    if (request.getCapitalInicial() <= 0) {
        return respuestaErrorInteres("Error: el capital inicial debe ser mayor a cero");
    }

    if (request.getTasaAnual() <= 0) {
        return respuestaErrorInteres("Error: la tasa anual debe ser mayor a cero");
    }

    if (request.getNumeroPeriodos() <= 0) {
        return respuestaErrorInteres("Error: el numero de periodos debe ser mayor a cero");
    }

    // A = P * (1 + r)^t
    double capitalFinal    = request.getCapitalInicial() * Math.pow(1 + (request.getTasaAnual() / 100), request.getNumeroPeriodos());
    double interesGenerado = capitalFinal - request.getCapitalInicial();

    String formula = request.getCapitalInicial()
        + " * (1 + " + request.getTasaAnual() + "%)^"
        + request.getNumeroPeriodos()
        + " = " + Math.round(capitalFinal * 100.0) / 100.0;

    InteresCompuestoResponseDTO response = new InteresCompuestoResponseDTO();
    response.setCapitalInicial(request.getCapitalInicial());
    response.setCapitalFinal(Math.round(capitalFinal * 100.0) / 100.0);
    response.setInteresGenerado(Math.round(interesGenerado * 100.0) / 100.0);
    response.setTasaAnual(request.getTasaAnual());
    response.setNumeroPeriodos(request.getNumeroPeriodos());
    response.setFormula(formula);
    response.setMensaje("Interes compuesto calculado correctamente");
    response.setStatus(200);
    response.setExitoso(true);
    return response;
}
}
