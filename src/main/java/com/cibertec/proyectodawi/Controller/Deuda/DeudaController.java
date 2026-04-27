package com.cibertec.proyectodawi.Controller.Deuda;

import com.cibertec.proyectodawi.dto.Deuda.Request.DeudaRequestDto;
import com.cibertec.proyectodawi.dto.Deuda.Response.DeudaResponseDto;
import com.cibertec.proyectodawi.services.Deuda.DeudaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deuda")
@RequiredArgsConstructor
public class DeudaController {

    private final DeudaService deudaService;

    @GetMapping
    public List<DeudaResponseDto> listar() {
        return deudaService.listar();
    }

    @GetMapping("/{id}")
    public DeudaResponseDto obtenerPorId(@PathVariable Long id) {
        return deudaService.obtenerPorId(id);
    }

    @PostMapping
    public DeudaResponseDto guardar(@RequestBody DeudaRequestDto dto) {
        return deudaService.guardar(dto);
    }

    @PutMapping("/{id}")
    public DeudaResponseDto actualizar(@PathVariable Long id, @RequestBody DeudaRequestDto dto) {
        return deudaService.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        deudaService.eliminar(id);
    }
}