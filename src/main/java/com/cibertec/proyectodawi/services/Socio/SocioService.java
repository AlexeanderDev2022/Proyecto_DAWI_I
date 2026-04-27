package com.cibertec.proyectodawi.services.Socio;

import com.cibertec.proyectodawi.Model.Socio.Socio;
import com.cibertec.proyectodawi.Repository.Socio.SocioRepository;
import  com.cibertec.proyectodawi.dto.Socio.Response.SocioSimpleDTO;
import com.cibertec.proyectodawi.dto.Socio.Response.SocioResponseDto;
import com.cibertec.proyectodawi.dto.Socio.Resquest.SocioRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SocioService {

    private final SocioRepository socioRepository;

    // ✅ LISTAR SOCIOS
    public List<SocioResponseDto> listarSocio() {
        return socioRepository.findAll()
                .stream()
                .map(socio -> new SocioResponseDto(
                        socio.getId(),
                        socio.getNombre(),
                        socio.getPuestos()
//
                ))
                .toList();
    }
    public SocioResponseDto obtenerPorId(Long id) {

        Socio socio = socioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Socio no encontrado"));

        return new SocioResponseDto(
                socio.getId(),
                socio.getNombre(),
                socio.getPuestos()
        );
    }
    // ✅ GUARDAR SOCIO
    public SocioResponseDto guardar(SocioRequestDto dto) {

        Socio socio = new Socio();
        socio.setNombre(dto.getNombre());

        Socio guardado = socioRepository.save(socio);

        return new SocioResponseDto(
                guardado.getId(),
                guardado.getNombre(),
                socio.getPuestos()
        );
    }

    // ✅ ACTUALIZAR SOCIO
    public SocioResponseDto actualizar(Long id, SocioRequestDto dto) {

        Socio existente = socioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Socio no encontrado"));

        existente.setNombre(dto.getNombre());

        Socio actualizado = socioRepository.save(existente);

        return new SocioResponseDto(
                actualizado.getId(),
                actualizado.getNombre(),
                actualizado.getPuestos()
        );
    }

    // ✅ ELIMINAR SOCIO
    public void eliminar(Long id) {

        Socio existente = socioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Socio no encontrado"));

        socioRepository.delete(existente);
    }
}