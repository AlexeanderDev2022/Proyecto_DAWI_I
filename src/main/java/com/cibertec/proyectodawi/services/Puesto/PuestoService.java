package com.cibertec.poyectodawi.services.Puesto;

import com.cibertec.poyectodawi.Mapper.PuestoMapper;
import com.cibertec.poyectodawi.Repository.Puesto.PuestoRepository;
import com.cibertec.poyectodawi.dto.Puesto.PuestoRequestDto;
import com.cibertec.poyectodawi.dto.Puesto.PuestoResponseDto;
import com.cibertec.poyectodawi.Model.Puesto.Puesto;
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
