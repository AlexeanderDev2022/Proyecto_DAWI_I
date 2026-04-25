package com.cibertec.proyectodawi.Mapper;

import com.cibertec.proyectodawi.dto.Puesto.PuestoRequestDto;
import com.cibertec.proyectodawi.dto.Puesto.PuestoResponseDto;
import com.cibertec.proyectodawi.Model.Puesto.Puesto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface PuestoMapper {
    
    PuestoResponseDto toDto(Puesto puesto);
    Puesto toEntity(PuestoRequestDto dto);
    
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(PuestoRequestDto dto, @MappingTarget Puesto entity);

    
}