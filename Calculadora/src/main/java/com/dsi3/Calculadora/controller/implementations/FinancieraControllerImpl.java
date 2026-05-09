package com.dsi3.Calculadora.controller.implementations;

import com.dsi3.Calculadora.controller.interfaces.IFinancieraController;
import com.dsi3.Calculadora.model.dto.InteresCompuestoRequestDTO;
import com.dsi3.Calculadora.model.dto.InteresCompuestoResponseDTO;
import com.dsi3.Calculadora.service.interfaces.IDivisasService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Financiera")
@RequiredArgsConstructor
public class FinancieraControllerImpl implements IFinancieraController {

    private final IDivisasService divisasService;

    private ResponseEntity<InteresCompuestoResponseDTO> buildResponse(InteresCompuestoResponseDTO response) {
        return response.isExitoso()
            ? ResponseEntity.status(HttpStatus.OK).body(response)
            : ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @Override
    @PostMapping("/interesCompuesto")
    public ResponseEntity<InteresCompuestoResponseDTO> calcularInteresCompuesto(@RequestBody InteresCompuestoRequestDTO request) {
        return buildResponse(divisasService.calcularInteresCompuesto(request));
    }
}