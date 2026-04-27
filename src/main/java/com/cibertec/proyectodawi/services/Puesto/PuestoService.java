package com.cibertec.proyectodawi.services.Puesto;

import com.cibertec.proyectodawi.Model.Puesto.Puesto;
import com.cibertec.proyectodawi.Model.Socio.Socio;
import com.cibertec.proyectodawi.Repository.Puesto.PuestoRepository;
import com.cibertec.proyectodawi.Repository.Socio.SocioRepository;
import com.cibertec.proyectodawi.dto.Puesto.request.PuestoRequestDto;
import com.cibertec.proyectodawi.dto.Puesto.response.PuestoResponseDto;
import com.cibertec.proyectodawi.dto.Socio.Response.SocioSimpleDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class PuestoService {

    private final PuestoRepository puestoRepository;
    private final SocioRepository socioRepository;

    // LISTAR
    public List<PuestoResponseDto> listarPuesto() {
        return puestoRepository.findAll()
                .stream()
                .map(puesto -> new PuestoResponseDto(
                        puesto.getId(),
                        puesto.getVersion(),
                        new SocioSimpleDTO(
                                puesto.getSocio() != null ? puesto.getSocio().getId() : null,
                                puesto.getSocio() != null ? puesto.getSocio().getNombre() : null
                        )
                ))
                .toList();
    }
    // BUSCAR POR ID
    public PuestoResponseDto obtenerPorId(Long id) {

        Puesto puesto = puestoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Puesto no encontrado"));

        return new PuestoResponseDto(
                puesto.getId(),
                puesto.getVersion(),
                puesto.getSocio() != null
                        ? new SocioSimpleDTO(
                        puesto.getSocio().getId(),
                        puesto.getSocio().getNombre()
                )
                        : null
        );
    }

    // GUARDAR
    public PuestoResponseDto guardar(PuestoRequestDto dto) {

        Socio socio = socioRepository.findById(dto.getSocioId())
                .orElseThrow(() -> new RuntimeException("Socio no encontrado"));

        Puesto puesto = new Puesto();
        puesto.setSocio(socio);
        puesto.setVersion(dto.getVersion());

        Puesto guardado = puestoRepository.save(puesto);

        return new PuestoResponseDto(
                guardado.getId(),
                guardado.getVersion(),
                new SocioSimpleDTO(
                        socio.getId(),
                        socio.getNombre()
                )
        );
    }

    // ACTUALIZAR
    public PuestoResponseDto actualizar(Long id, PuestoRequestDto dto) {

        Puesto existente = puestoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Puesto no encontrado"));

        Socio socio = socioRepository.findById(dto.getSocioId())
                .orElseThrow(() -> new RuntimeException("Socio no encontrado"));

        existente.setSocio(socio);
        existente.setVersion(dto.getVersion());

        Puesto actualizado = puestoRepository.save(existente);

        return new PuestoResponseDto(
                actualizado.getId(),
                actualizado.getVersion(),
                new SocioSimpleDTO(
                        socio.getId(),
                        socio.getNombre()
                )
        );
    }

    // ELIMINAR
    public void eliminar(Long id) {
        Puesto existente = puestoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Puesto no encontrado"));

        puestoRepository.delete(existente);
    }
}