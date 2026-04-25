package com.cibertec.poyectodawi.Controller.Reporte;

import com.cibertec.poyectodawi.dto.Reporte.*;
import com.cibertec.poyectodawi.services.Reporte.ReporteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/reportes")
@RequiredArgsConstructor
public class ReporteController {

    private final ReporteService reporteService;

    // Flujo de caja(Ejemplo para probar: http://localhost:8080/reportes/flujo?fecha=2026-04-24 )
    @GetMapping("/flujo")
    public ResponseEntity<FlujoCajaDto> flujo(@RequestParam String fecha){
        return ResponseEntity.ok(
                reporteService.flujoDiario(LocalDate.parse(fecha))
        );
    }

    // Deuda por socio (Ejemplo para probar: http://localhost:8080/reportes/deuda-socio )
    @GetMapping("/deuda-socio")
    public ResponseEntity<List<DeudaSocioDto>> deudaPorSocio(){
        return ResponseEntity.ok(reporteService.deudaPorSocio());
    }

    // Deudores críticos (Ejemplo para probar: http://localhost:8080/reportes/deudores-criticos?monto=300 )
    @GetMapping("/deudores-criticos")
    public ResponseEntity<List<DeudorCriticoDto>> deudoresCriticos(@RequestParam Double monto){
        return ResponseEntity.ok(
                reporteService.deudoresCriticos(monto)
        );
    }

    // Top socios (Ejemplo para probar: http://localhost:8080/reportes/top-socios )
    @GetMapping("/top-socios")
    public ResponseEntity<List<TopSocioDto>> topSocios(){
        return ResponseEntity.ok(reporteService.topSocios());
    }
}