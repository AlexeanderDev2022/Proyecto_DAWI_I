package com.cibertec.proyectodawi.services.Puesto;

import com.cibertec.proyectodawi.Mapper.PuestoMapper;
import com.cibertec.proyectodawi.Repository.Puesto.PuestoRepository;
import com.cibertec.proyectodawi.dto.Puesto.PuestoRequestDto;
import com.cibertec.proyectodawi.dto.Puesto.PuestoResponseDto;
import com.cibertec.proyectodawi.Model.Puesto.Puesto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PuestoService {
    private final PuestoRepository puestoRepository;
    private final PuestoMapper puestoMapper;


    public List<PuestoResponseDto> listarPuesto() {
        return puestoRepository.findAll()
                .stream()
                .map(puestoMapper::toDto)
                .toList();

    }

    public PuestoResponseDto guardar(PuestoRequestDto dto) {
        Puesto puesto = puestoMapper.toEntity(dto);
        Puesto guardado = puestoRepository.save(puesto);
        return puestoMapper.toDto(guardado);
    }

//
public PuestoResponseDto actualizar(Long id, PuestoRequestDto dto) {

    var existente = puestoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Puesto no encontrado"));
        puestoMapper.updateEntity(dto, existente);

    var actualizado = puestoRepository.save(existente);

    return puestoMapper.toDto(actualizado);
}
    public void eliminar(Long id) {

        var existente = puestoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Puesto no encontrado"));

        puestoRepository.delete(existente);
    }


}
