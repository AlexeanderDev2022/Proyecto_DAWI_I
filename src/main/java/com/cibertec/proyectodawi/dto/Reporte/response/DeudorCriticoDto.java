package com.cibertec.proyectodawi.dto.Reporte.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeudorCriticoDto {
    private String socio;
    private Double deuda;
    private String estado;
}