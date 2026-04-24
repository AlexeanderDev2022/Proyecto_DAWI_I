package com.cibertec.poyectodawi.Mapper;

import com.cibertec.poyectodawi.dto.Puesto.PuestoRequestDto;
import com.cibertec.poyectodawi.dto.Puesto.PuestoResponseDto;
import com.cibertec.poyectodawi.Model.Puesto.Puesto;
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