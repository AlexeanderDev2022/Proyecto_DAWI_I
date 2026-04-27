package com.cibertec.proyectodawi.Controller.Socio;

import com.cibertec.proyectodawi.dto.Socio.Response.SocioResponseDto;
import com.cibertec.proyectodawi.dto.Socio.Response.SocioSimpleDTO;
import com.cibertec.proyectodawi.dto.Socio.Resquest.SocioRequestDto;
import com.cibertec.proyectodawi.services.Socio.SocioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/socio")
@RequiredArgsConstructor
public class SocioController {
    private final SocioService socioService ;
    @GetMapping()
    public ResponseEntity<List<SocioResponseDto>> socio (){
        return ResponseEntity.ok(socioService.listarSocio());
    }
    @GetMapping("{id}")
    public ResponseEntity<List<SocioResponseDto>> socio (@PathVariable Long id){
        return ResponseEntity.ok(Collections.singletonList(socioService.obtenerPorId(id)));
    }
    @PostMapping()
    public ResponseEntity<SocioResponseDto> socio (@RequestBody SocioRequestDto socio){
        return ResponseEntity.ok(socioService.guardar(socio));
    }
}
