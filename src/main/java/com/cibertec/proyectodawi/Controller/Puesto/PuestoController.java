package com.cibertec.proyectodawi.Controller.Puesto;


import com.cibertec.proyectodawi.dto.Puesto.PuestoRequestDto;
import com.cibertec.proyectodawi.dto.Puesto.PuestoResponseDto;
import com.cibertec.proyectodawi.services.Puesto.PuestoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.PathMatcher;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/puesto")

    public class PuestoController {
    private final PuestoService puestoService;
    private final PathMatcher pathMatcher;

    @GetMapping()
    public ResponseEntity<List<PuestoResponseDto>> listar() {
        return ResponseEntity.ok(puestoService.listarPuesto());
    }

    @PostMapping()
    public ResponseEntity<PuestoResponseDto> guardar(@RequestBody @Valid PuestoRequestDto requestDto) {
        return ResponseEntity.ok(puestoService.guardar(requestDto));


    }

    @PutMapping("/{id}")
    public ResponseEntity<PuestoResponseDto> actualiar(@PathVariable Long id, @RequestBody PuestoRequestDto requestDto) {

        return ResponseEntity.ok(puestoService.actualizar(id, requestDto));
    }
}
