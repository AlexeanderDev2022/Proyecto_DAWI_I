package com.cibertec.poyectodawi.Mapper;

import com.cibertec.poyectodawi.dto.Puesto.PuestoRequestDto;
import com.cibertec.poyectodawi.dto.Puesto.PuestoResponseDto;
import com.cibertec.poyectodawi.Model.Puesto.Puesto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PuestoMapper {
    PuestoResponseDto toDto(Puesto puesto);
    Puesto toEntity(PuestoRequestDto dto);
}