package com.cibertec.poyectodawi.dto.Puesto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PuestoResponseDto {
    private Long id;
    private String dueno;
    private Integer version;
}
