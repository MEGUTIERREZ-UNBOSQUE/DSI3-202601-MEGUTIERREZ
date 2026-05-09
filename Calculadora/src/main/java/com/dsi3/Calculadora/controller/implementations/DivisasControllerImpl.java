package com.dsi3.Calculadora.controller.implementations;

import com.dsi3.Calculadora.controller.interfaces.IDivisasController;
import com.dsi3.Calculadora.model.dto.DivisasRequestDTO;
import com.dsi3.Calculadora.model.dto.DivisasResponseDTO;
import com.dsi3.Calculadora.service.interfaces.IDivisasService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Divisas")
@RequiredArgsConstructor
public class DivisasControllerImpl implements IDivisasController {

    private final IDivisasService divisasService;

    private ResponseEntity<DivisasResponseDTO> buildResponse(DivisasResponseDTO response) {
        return response.isExitoso()
            ? ResponseEntity.status(HttpStatus.OK).body(response)
            : ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @Override
    @PostMapping("/convertir")
    public ResponseEntity<DivisasResponseDTO> convertir(@RequestBody DivisasRequestDTO request) {
        return buildResponse(divisasService.convertir(request));
    }

    @Override
    @PostMapping("/euro")
    public ResponseEntity<DivisasResponseDTO> convertirAEuro(@RequestBody DivisasRequestDTO request) {
        return buildResponse(divisasService.convertirAEuro(request));
    }

    @Override
    @PostMapping("/dolar")
    public ResponseEntity<DivisasResponseDTO> convertirADolar(@RequestBody DivisasRequestDTO request) {
        return buildResponse(divisasService.convertirADolar(request));
    }

    @Override
    @PostMapping("/libra")
    public ResponseEntity<DivisasResponseDTO> convertirALibra(@RequestBody DivisasRequestDTO request) {
        return buildResponse(divisasService.convertirALibra(request));
    }

    @Override
    @PostMapping("/yen")
    public ResponseEntity<DivisasResponseDTO> convertirAYen(@RequestBody DivisasRequestDTO request) {
        return buildResponse(divisasService.convertirAYen(request));
    }

    @Override
    @PostMapping("/bitcoin")
    public ResponseEntity<DivisasResponseDTO> convertirABitcoin(@RequestBody DivisasRequestDTO request) {
        return buildResponse(divisasService.convertirABitcoin(request));
    }
}