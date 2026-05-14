package com.dsi3.Calculadora.controller.implementations;

import com.dsi3.Calculadora.controller.interfaces.ICientificaController;
import com.dsi3.Calculadora.model.dto.CientificaRequestDTO;
import com.dsi3.Calculadora.model.dto.CientificaResponseDTO;
import com.dsi3.Calculadora.service.interfaces.ICientificaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Cientifica")
@RequiredArgsConstructor
public class CientificaControllerImpl implements ICientificaController {

    private final ICientificaService cientificaService;

    private ResponseEntity<CientificaResponseDTO> buildResponse(CientificaResponseDTO response) {
        return response.isExitoso()
            ? ResponseEntity.status(HttpStatus.OK).body(response)
            : ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @Override
    @PostMapping("/seno")
    public ResponseEntity<CientificaResponseDTO> seno(@RequestBody CientificaRequestDTO request) {
        return buildResponse(cientificaService.calcularSeno(request));
    }

    @Override
    @PostMapping("/coseno")
    public ResponseEntity<CientificaResponseDTO> coseno(@RequestBody CientificaRequestDTO request) {
        return buildResponse(cientificaService.calcularCoseno(request));
    }

    @Override
    @PostMapping("/tangente")
    public ResponseEntity<CientificaResponseDTO> tangente(@RequestBody CientificaRequestDTO request) {
        return buildResponse(cientificaService.calcularTangente(request));
    }

    @Override
    @PostMapping("/raiz")
    public ResponseEntity<CientificaResponseDTO> raizCuadrada(@RequestBody CientificaRequestDTO request) {
        return buildResponse(cientificaService.calcularRaizCuadrada(request));
    }

    @Override
    @PostMapping("/potencia")
    public ResponseEntity<CientificaResponseDTO> potencia(@RequestBody CientificaRequestDTO request) {
        return buildResponse(cientificaService.calcularPotencia(request));
    }

    @Override
    @PostMapping("/log")
    public ResponseEntity<CientificaResponseDTO> logaritmo(@RequestBody CientificaRequestDTO request) {
        return buildResponse(cientificaService.calcularLogaritmo(request));
    }

    @Override
    @PostMapping("/ln")
    public ResponseEntity<CientificaResponseDTO> logNatural(@RequestBody CientificaRequestDTO request) {
        return buildResponse(cientificaService.calcularLogNatural(request));
    }

    @Override
    @PostMapping("/exp")
    public ResponseEntity<CientificaResponseDTO> exponencial(@RequestBody CientificaRequestDTO request) {
        return buildResponse(cientificaService.calcularExponencial(request));
    }

    @Override
    @PostMapping("/operar")
    public ResponseEntity<CientificaResponseDTO> operar(@RequestBody CientificaRequestDTO request) {
        return buildResponse(cientificaService.operar(request));
    }
}