package com.cibertec.proyectodawi.Controller.Pago;

import com.cibertec.proyectodawi.dto.Boleta.Request.BoletaRequestDto;
import com.cibertec.proyectodawi.dto.Boleta.Response.BoletaResponseDto;
import com.cibertec.proyectodawi.services.Pago.BoletaService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pagos")
@RequiredArgsConstructor
public class PagoController {

    private final BoletaService boletaService;

    @PostMapping("/generar")
    public ResponseEntity<BoletaResponseDto> generar(@RequestBody BoletaRequestDto request) {
        BoletaResponseDto response = boletaService.registrarPago(request);
        return ResponseEntity.ok(response);
    }
}