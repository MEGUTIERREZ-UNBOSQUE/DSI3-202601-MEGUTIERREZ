package com.dsi3.Calculadora.controller.implementations;

import com.dsi3.Calculadora.controller.interfaces.ICalculatorController;
import com.dsi3.Calculadora.model.dto.CalculadoraRequestDTO;
import com.dsi3.Calculadora.model.dto.CalculadoraResponseDTO;
import com.dsi3.Calculadora.service.interfaces.ICalculatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Calculadora")
@RequiredArgsConstructor
public class CalculatorControllerImpl implements ICalculatorController {

    private final ICalculatorService calculatorService;

    private ResponseEntity<CalculadoraResponseDTO> buildResponse(CalculadoraResponseDTO response) {
        return response.isExitoso()
            ? ResponseEntity.status(HttpStatus.OK).body(response)
            : ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @Override
    @PostMapping("/calcular")
    public ResponseEntity<CalculadoraResponseDTO> calcular(@RequestBody CalculadoraRequestDTO request) {
        return buildResponse(calculatorService.calcular(request));
    }

    @Override
    @PostMapping("/sumar")
    public ResponseEntity<CalculadoraResponseDTO> sumar(@RequestBody CalculadoraRequestDTO request) {
        return buildResponse(calculatorService.sumar(request));
    }

    @Override
    @PostMapping("/restar")
    public ResponseEntity<CalculadoraResponseDTO> restar(@RequestBody CalculadoraRequestDTO request) {
        return buildResponse(calculatorService.restar(request));
    }

    @Override
    @PostMapping("/multiplicar")
    public ResponseEntity<CalculadoraResponseDTO> multiplicar(@RequestBody CalculadoraRequestDTO request) {
        return buildResponse(calculatorService.multiplicar(request));
    }

    @Override
    @PostMapping("/dividir")
    public ResponseEntity<CalculadoraResponseDTO> dividir(@RequestBody CalculadoraRequestDTO request) {
        return buildResponse(calculatorService.dividir(request));
    }
}