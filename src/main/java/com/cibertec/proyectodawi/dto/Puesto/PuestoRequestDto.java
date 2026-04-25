package com.cibertec.proyectodawi.dto.Puesto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PuestoRequestDto {
    private String dueno;
    private Integer version;
}
