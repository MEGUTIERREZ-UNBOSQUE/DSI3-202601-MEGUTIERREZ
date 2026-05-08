package com.dsi3.Calculadora.model.dto;

public class CalculadoraResponseDTO {
    private double resultado;
    private String mensaje;
    private String operacionRealizada;
    private boolean exitoso;
    private double resultadoConversion;
    private String monedaDestino;

    public CalculadoraResponseDTO(double resultado, String mensaje, String operacionRealizada, boolean exitoso) {
        this.resultado = resultado;
        this.mensaje = mensaje;
        this.operacionRealizada = operacionRealizada;
        this.exitoso = exitoso;
    }

    public CalculadoraResponseDTO(double resultado, String mensaje, String operacionRealizada, boolean exitoso, double resultadoConversion, String monedaDestino) {
        this.resultado = resultado;
        this.mensaje = mensaje;
        this.operacionRealizada = operacionRealizada;
        this.exitoso = exitoso;
        this.resultadoConversion = resultadoConversion;
        this.monedaDestino = monedaDestino;
    }

    public double getResultado() { return resultado; }
    public String getMensaje() { return mensaje; }
    public String getOperacionRealizada() { return operacionRealizada; }
    public boolean isExitoso() { return exitoso; }
    public double getResultadoConversion() { return resultadoConversion; }
    public String getMonedaDestino() { return monedaDestino; }
}