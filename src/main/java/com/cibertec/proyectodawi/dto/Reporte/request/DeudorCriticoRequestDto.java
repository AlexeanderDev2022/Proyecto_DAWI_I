package com.cibertec.proyectodawi.dto.Reporte.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeudorCriticoRequestDto {
    private String socio;
    private Double deuda;
    private String estado;
}