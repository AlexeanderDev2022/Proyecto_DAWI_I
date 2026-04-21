package com.cibertec.poyectodawi.cotroller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/puestos")
public class PuestoController {
    @GetMapping()
public String puestos(){
    return "puestos";
    }
}
