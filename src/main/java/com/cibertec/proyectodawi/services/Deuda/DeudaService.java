package com.cibertec.proyectodawi.services.Deuda;

import com.cibertec.proyectodawi.Model.Deuda.Deuda;
import com.cibertec.proyectodawi.Model.Puesto.Puesto;
import com.cibertec.proyectodawi.Model.Socio.Socio;
import com.cibertec.proyectodawi.Repository.Deuda.DeudaRepository;
import com.cibertec.proyectodawi.Repository.Puesto.PuestoRepository;
import com.cibertec.proyectodawi.Repository.Socio.SocioRepository;

import com.cibertec.proyectodawi.dto.Deuda.Request.DeudaRequestDto;
import com.cibertec.proyectodawi.dto.Deuda.Response.DeudaResponseDto;
import com.cibertec.proyectodawi.dto.Puesto.response.PuestoSimpleDto;
import com.cibertec.proyectodawi.dto.Socio.Response.SocioSimpleDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeudaService {

    private final DeudaRepository deudaRepository;
    private final SocioRepository socioRepository;
    private final PuestoRepository puestoRepository;

    // LISTAR
    public List<DeudaResponseDto> listar() {
        return deudaRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .toList();
    }

    // OBTENER POR ID
    public DeudaResponseDto obtenerPorId(Long id) {
        Deuda deuda = deudaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Deuda no encontrada"));

        return mapToDto(deuda);
    }

    // GUARDAR
    public DeudaResponseDto guardar(DeudaRequestDto dto) {

        Socio socio = socioRepository.findById(dto.getSocioId())
                .orElseThrow(() -> new RuntimeException("Socio no encontrado"));

        Puesto puesto = puestoRepository.findById(dto.getPuestoId())
                .orElseThrow(() -> new RuntimeException("Puesto no encontrado"));

        Deuda deuda = new Deuda();
        deuda.setMonto(dto.getMonto());
        deuda.setFechaVencimiento(dto.getFechaVencimiento());
        deuda.setPagado(dto.getPagado());
        deuda.setMotivo(dto.getMotivo());
        deuda.setSocio(socio);
        deuda.setPuesto(puesto);

        return mapToDto(deudaRepository.save(deuda));
    }

    // ACTUALIZAR
    public DeudaResponseDto actualizar(Long id, DeudaRequestDto dto) {

        Deuda deuda = deudaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Deuda no encontrada"));

        Socio socio = socioRepository.findById(dto.getSocioId())
                .orElseThrow(() -> new RuntimeException("Socio no encontrado"));

        Puesto puesto = puestoRepository.findById(dto.getPuestoId())
                .orElseThrow(() -> new RuntimeException("Puesto no encontrado"));

        deuda.setMonto(dto.getMonto());
        deuda.setFechaVencimiento(dto.getFechaVencimiento());
        deuda.setPagado(dto.getPagado());
        deuda.setMotivo(dto.getMotivo());
        deuda.setSocio(socio);
        deuda.setPuesto(puesto);

        return mapToDto(deudaRepository.save(deuda));
    }

    // ELIMINAR
    public void eliminar(Long id) {
        Deuda deuda = deudaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Deuda no encontrada"));

        deudaRepository.delete(deuda);
    }

    // MAPPER
    private DeudaResponseDto mapToDto(Deuda deuda) {

        return new DeudaResponseDto(
                deuda.getId(),
                deuda.getMonto(),
                deuda.getFechaVencimiento(),
                deuda.getPagado(),
                deuda.getMotivo(),

                deuda.getSocio() != null
                        ? new SocioSimpleDTO(
                        deuda.getSocio().getId(),
                        deuda.getSocio().getNombre()
                )
                        : null,

                deuda.getPuesto() != null
                        ? new PuestoSimpleDto(
                        deuda.getPuesto().getId(),
                        deuda.getPuesto().getVersion()
                )
                        : null
        );
    }
}