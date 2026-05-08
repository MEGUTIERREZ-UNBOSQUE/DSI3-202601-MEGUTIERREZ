package com.dsi3.Calculadora.model.dto;

public class CalculadoraRequestDTO {
    private double primerOperando;
    private double segundoOperando;
    private String operacion;
    private double montoPesos;
    private String monedaDestino;

    public double getPrimerOperando() { return primerOperando; }
    public void setPrimerOperando(double primerOperando) { this.primerOperando = primerOperando; }

    public double getSegundoOperando() { return segundoOperando; }
    public void setSegundoOperando(double segundoOperando) { this.segundoOperando = segundoOperando; }

    public String getOperacion() { return operacion; }
    public void setOperacion(String operacion) { this.operacion = operacion; }

    public double getMontoPesos() { return montoPesos; }
    public void setMontoPesos(double montoPesos) { this.montoPesos = montoPesos; }

    public String getMonedaDestino() { return monedaDestino; }
    public void setMonedaDestino(String monedaDestino) { this.monedaDestino = monedaDestino; }
}