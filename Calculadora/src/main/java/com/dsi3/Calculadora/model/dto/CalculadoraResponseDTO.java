package com.dsi3.Calculadora.model.dto;

public class CalculadoraResponseDTO {
    private double resultado;
    private String mensaje;
    private String operacionRealizada;
    private boolean exitoso;

    public CalculadoraResponseDTO(double resultado, String mensaje, String operacionRealizada, boolean exitoso) {
        this.resultado = resultado;
        this.mensaje = mensaje;
        this.operacionRealizada = operacionRealizada;
        this.exitoso = exitoso;
    }

    public double getResultado() { return resultado; }
    public String getMensaje() { return mensaje; }
    public String getOperacionRealizada() { return operacionRealizada; }
    public boolean isExitoso() { return exitoso; }
}
