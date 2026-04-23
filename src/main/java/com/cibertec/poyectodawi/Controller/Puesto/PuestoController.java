package com.cibertec.poyectodawi.Controller.Puesto;


import com.cibertec.poyectodawi.dto.Puesto.PuestoRequestDto;
import com.cibertec.poyectodawi.dto.Puesto.PuestoResponseDto;
import com.cibertec.poyectodawi.services.Puesto.PuestoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/puestos")

    public class PuestoController {
    private final PuestoService puestoService;

    @GetMapping()
    public ResponseEntity<List<PuestoResponseDto>> puestos(){
    return ResponseEntity.ok(puestoService.listarPuesto());
    }
    @PostMapping()
    public ResponseEntity<PuestoResponseDto>Guardar (@RequestBody @Valid  PuestoRequestDto requestDto){
        return ResponseEntity.ok(puestoService.guardar(requestDto));
        

    }


}
