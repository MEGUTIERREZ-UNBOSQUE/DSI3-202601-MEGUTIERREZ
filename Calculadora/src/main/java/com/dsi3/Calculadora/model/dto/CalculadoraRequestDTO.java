package com.dsi3.Calculadora.model.dto;

public class CalculadoraRequestDTO {
    private double primerOperando;
    private double segundoOperando;
    private String operacion;

    public double getPrimerOperando() { return primerOperando; }
    public void setPrimerOperando(double primerOperando) { this.primerOperando = primerOperando; }

    public double getSegundoOperando() { return segundoOperando; }
    public void setSegundoOperando(double segundoOperando) { this.segundoOperando = segundoOperando; }

    public String getOperacion() { return operacion; }
    public void setOperacion(String operacion) { this.operacion = operacion; }
}
