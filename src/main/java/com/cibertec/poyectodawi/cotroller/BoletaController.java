package com.cibertec.poyectodawi.cotroller;

import com.cibertec.poyectodawi.model.Boleta;
import com.cibertec.poyectodawi.service.BoletaService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pagos")
public class BoletaController {

    private final BoletaService service;

    public BoletaController(BoletaService service) {
        this.service = service;
    }

    @PostMapping("/generar")
    public Boleta generar(@RequestParam Double monto, @RequestParam String concepto) {
        return service.registrarPago(monto, concepto);
    }
}