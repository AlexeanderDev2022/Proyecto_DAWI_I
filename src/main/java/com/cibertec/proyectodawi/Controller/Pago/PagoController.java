package com.cibertec.proyectodawi.Controller.Pago;

import com.cibertec.proyectodawi.Model.Boleta;
import com.cibertec.proyectodawi.services.Pago.BoletaService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pagos")
public class PagoController {

    private final BoletaService service;

    public PagoController(BoletaService service) {
        this.service = service;
    }

    @PostMapping("/generar")
    public Boleta generar(@RequestParam Double monto, @RequestParam String concepto) {
        return service.registrarPago(monto, concepto);
    }
}