package com.dsi3.Calculadora.controller.implementations;

import com.dsi3.Calculadora.controller.interfaces.CalculatorController;
import com.dsi3.Calculadora.model.dto.CalculadoraRequestDTO;
import com.dsi3.Calculadora.model.dto.CalculadoraResponseDTO;
import com.dsi3.Calculadora.service.interfaces.CalculatorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Calculadora")
public class CalculatorControllerImpl implements CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorControllerImpl(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @Override
    @PostMapping("/calcular")
    public ResponseEntity<CalculadoraResponseDTO> calcular(@RequestBody CalculadoraRequestDTO request) {
        return ResponseEntity.ok(calculatorService.calcular(request));
    }

    @Override
    @PostMapping("/sumar")
    public ResponseEntity<CalculadoraResponseDTO> sumar(@RequestBody CalculadoraRequestDTO request) {
        return ResponseEntity.ok(calculatorService.sumar(request));
    }

    @Override
    @PostMapping("/restar")
    public ResponseEntity<CalculadoraResponseDTO> restar(@RequestBody CalculadoraRequestDTO request) {
        return ResponseEntity.ok(calculatorService.restar(request));
    }

    @Override
    @PostMapping("/multiplicar")
    public ResponseEntity<CalculadoraResponseDTO> multiplicar(@RequestBody CalculadoraRequestDTO request) {
        return ResponseEntity.ok(calculatorService.multiplicar(request));
    }

    @Override
    @PostMapping("/dividir")
    public ResponseEntity<CalculadoraResponseDTO> dividir(@RequestBody CalculadoraRequestDTO request) {
        return ResponseEntity.ok(calculatorService.dividir(request));
    }

    @Override
    @PostMapping("/convertir")
    public ResponseEntity<CalculadoraResponseDTO> convertirMoneda(@RequestBody CalculadoraRequestDTO request) {
        return ResponseEntity.ok(calculatorService.convertirMoneda(request));
    }
}